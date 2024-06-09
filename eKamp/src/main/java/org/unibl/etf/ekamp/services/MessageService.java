package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Message;
import org.unibl.etf.ekamp.model.requests.MessageRequest;

import java.util.List;

public interface MessageService extends CrudService<Integer> {

     Message insert(MessageRequest request);
     List<Message> findAllSorted();
}
