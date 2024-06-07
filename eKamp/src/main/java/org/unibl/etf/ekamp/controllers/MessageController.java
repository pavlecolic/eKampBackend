package org.unibl.etf.ekamp.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.Message;
import org.unibl.etf.ekamp.model.requests.MessageRequest;
import org.unibl.etf.ekamp.services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController extends CrudController<Integer, MessageRequest, Message> {

    private final MessageService messageService;
    protected MessageController(MessageService messageService) {
        super(Message.class, messageService);
        this.messageService = messageService;
    }

    @PostMapping
    public Message insert(@Valid @RequestBody MessageRequest request) {
        return messageService.insert(request);
    }
}
