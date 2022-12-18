package emlakcepte.service;

import emlakcepte.model.Message;
import emlakcepte.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void create(Message message) {
        messageRepository.saveMessage(message);
    }

    public void update(Message message) {
        messageRepository.saveMessage(message);
    }

    public void delete(Message message) {
        messageRepository.delete(message);
    }


}
