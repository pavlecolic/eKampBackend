package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Message;
import org.unibl.etf.ekamp.model.requests.MessageRequest;

public interface MessageService extends CrudService<Integer> {

     Message insert(MessageRequest request);
}
