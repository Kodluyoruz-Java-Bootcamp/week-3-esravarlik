package emlakcepte.controller;

import emlakcepte.model.Message;
import emlakcepte.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message) {
        System.out.println("message" + message);
        messageService.create(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Message> update(Message message) {
        System.out.println("message" + message);
        messageService.update(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Message> delete(Message message) {
        messageService.delete(message);
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }

}
