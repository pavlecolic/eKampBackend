package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.dto.UserMessages;
import org.unibl.etf.ekamp.model.entities.UserMessagesEntity;
import org.unibl.etf.ekamp.model.entities.UserMessagesEntityId;

import java.util.List;

public interface UserMessagesRepository extends JpaRepository<UserMessagesEntity, UserMessagesEntityId> {

    List<UserMessagesEntity> getAllByEmployeeId(Integer id);
}
