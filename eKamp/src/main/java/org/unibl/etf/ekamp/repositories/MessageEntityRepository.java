package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.MessageEntity;

public interface MessageEntityRepository extends JpaRepository<MessageEntity, Integer> {
}
