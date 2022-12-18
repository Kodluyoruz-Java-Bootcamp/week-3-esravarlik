package com.jojo.mediumproject.service;

import com.jojo.mediumproject.model.User;
import com.jojo.mediumproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Creates a user if the password
     * has more than five characters.
     *
     * @param user
     * @return void
     */
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

    /**
     * Prints all articles.
     *
     * @return void
     */
    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println("createUser :: " + user.getUserName()));

    }
}
