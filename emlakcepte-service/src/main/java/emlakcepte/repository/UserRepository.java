package emlakcepte.repository;

import emlakcepte.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public void saveHistory(String history, User user) {
        user.addSearch(history);
    }

}
