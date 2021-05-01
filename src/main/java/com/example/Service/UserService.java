package com.example.Service;



import com.example.entities.User;
import org.springframework.context.annotation.Bean;

import java.util.List;
public interface UserService {
    List<User> getAllUsers();
    User getUserByPhone(String phone);
    void deletUser(Long id);
    User findUserById(Long id);
    void newUser(User user);
    User getByUsername(String name);
}
