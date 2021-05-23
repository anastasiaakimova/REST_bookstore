package com.akimova.example.service.impl;

import com.akimova.example.model.User;
import com.akimova.example.repo.UserRepo;
import com.akimova.example.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements GeneralService<User> {

    @Autowired
    UserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findUserByUsername(name);
    }
}
