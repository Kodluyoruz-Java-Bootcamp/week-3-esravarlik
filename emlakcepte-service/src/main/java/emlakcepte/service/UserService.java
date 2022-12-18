package emlakcepte.service;

import emlakcepte.model.User;
import emlakcepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Password must be at least 5 characters. ");
        } else {
            userRepository.createUser(user);
        }
    }

    public List<User> getAllUser() {
        return userRepository.findAllUsers();
    }

    public void printAllUser() {

        getAllUser().forEach(user -> System.out.println(user.getName()));
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userRepository.createUser(user);
    }

    public void saveHistory(String history, User user) {
        userRepository.saveHistory(history, user);
    }

    public User getByEmail(String email) {

        return userRepository.findAllUsers()
                .stream()
                .filter(user -> user.getMail().equals(email))
                .findFirst()
                .get();
    }

}
