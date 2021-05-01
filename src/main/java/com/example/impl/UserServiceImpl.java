package com.example.impl;

import com.example.Service.UserService;
import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

    @Service
    public class UserServiceImpl implements UserService, UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(s);
            if (user == null){
                throw new UsernameNotFoundException("Not found such " + s);
            }
            return user;
        }

        @Override
        public void deletUser(Long id) {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
        }

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public User getUserByPhone(String phone) {
            User user = userRepository.findByPhone(phone);
            if (user == null){
                throw new RuntimeException("Not found owner with " + phone);
            }
            return user;
        }

        @Override
        public User findUserById(Long id) {
            User user = userRepository.findById(id).get();
            return user;

        }

        @Override
        public void newUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }

        @Override
        public User getByUsername(String username) {
            return userRepository.findByUsername(username);
        }
    }
