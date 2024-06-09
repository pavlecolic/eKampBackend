package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.Message;
import org.unibl.etf.ekamp.model.dto.UserMessages;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.entities.MessageEntity;
import org.unibl.etf.ekamp.model.entities.UserMessagesEntity;
import org.unibl.etf.ekamp.model.entities.UserMessagesEntityId;
import org.unibl.etf.ekamp.model.requests.MessageRequest;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.repositories.MessageEntityRepository;
import org.unibl.etf.ekamp.repositories.UserMessagesRepository;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.services.MessageService;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl extends CrudJpaService<MessageEntity, Integer> implements MessageService {

    private final EmployeeEntityRepository employeeEntityRepository;
    private final UserMessagesRepository userMessagesRepository;
    private final EmployeeService employeeService;

    public MessageServiceImpl(MessageEntityRepository repository, ModelMapper modelMapper, EmployeeEntityRepository employeeEntityRepository, UserMessagesRepository userMessagesRepository, EmployeeService employeeService) {
        super(repository, MessageEntity.class, modelMapper);
        this.employeeEntityRepository = employeeEntityRepository;
        this.userMessagesRepository = userMessagesRepository;
        this.employeeService = employeeService;
    }

    @Override
    public Message insert(MessageRequest request) {
        Employee creator = employeeService.findById(request.getEmployeeId(), Employee.class);

        Message message = new Message();
        message.setEmployeeId(creator.getId());
        message.setEmployeeUsername(creator.getUsername());
        message.setContent(request.getContent());
        message.setCreationTime(request.getCreationTime() != null ? request.getCreationTime() : LocalDateTime.from(Instant.now()));

        MessageEntity messageEntity = getRepository().save(getModelMapper().map(message, MessageEntity.class));

        List<EmployeeEntity> employeeEntityList = employeeEntityRepository.findAll();
        EmployeeEntity creatorEntity = getModelMapper().map(creator, EmployeeEntity.class);
        for(EmployeeEntity employee : employeeEntityList) {
            UserMessagesEntity userMessagesEntity = new UserMessagesEntity();
            UserMessagesEntityId userMessagesEntityId = new UserMessagesEntityId();
            userMessagesEntityId.setMessageId(messageEntity.getId());
            userMessagesEntityId.setEmployeePersonId(employee.getId());

            userMessagesEntity.setId(userMessagesEntityId);
            userMessagesEntity.setMessage(messageEntity);
            userMessagesEntity.setEmployee(employee);
            if(!creatorEntity.getId().equals(employee.getId())) {
                userMessagesEntity.setReadAt(null);
            } else {
                userMessagesEntity.setReadAt(Timestamp.from(Instant.now()));
            }
            userMessagesRepository.save(userMessagesEntity);
        }
        return getModelMapper().map(messageEntity, Message.class);
    }

    @Override
    public List<Message> findAllSorted() {
        List<MessageEntity> messages = getRepository().findAll();
        return messages.stream()
                .map(messageEntity -> getModelMapper().map(messageEntity, Message.class))
                .sorted(Comparator.comparing(Message::getCreationTime).reversed())
                .collect(Collectors.toList());
    }
}
