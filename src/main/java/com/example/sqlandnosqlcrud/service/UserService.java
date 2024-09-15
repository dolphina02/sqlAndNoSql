package com.example.sqlandnosqlcrud.service;

import com.example.sqlandnosqlcrud.entity.User;
import com.example.sqlandnosqlcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUserInfo() {
        return userRepository.findAll();
    }

    public void deleteUserInfo(Long id) {
        userRepository.deleteById(id);
    }
}
