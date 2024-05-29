package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.MessageEntity;
import org.unibl.etf.ekamp.repositories.MessageEntityRepository;
import org.unibl.etf.ekamp.services.MessageService;

@Service
@Transactional
public class MessageServiceImpl extends CrudJpaService<MessageEntity, Integer> implements MessageService {
    public MessageServiceImpl(MessageEntityRepository repository, ModelMapper modelMapper) {
        super(repository, MessageEntity.class, modelMapper);
    }
}
