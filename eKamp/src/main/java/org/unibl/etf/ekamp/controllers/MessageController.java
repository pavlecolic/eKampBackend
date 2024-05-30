package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.Message;
import org.unibl.etf.ekamp.model.requests.MessageRequest;
import org.unibl.etf.ekamp.services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController extends CrudController<Integer, MessageRequest, Message> {
    protected MessageController(MessageService messageService) {
        super(Message.class, messageService);
    }
}
