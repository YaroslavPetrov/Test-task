package com.petroff.testtask.services;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.exceptions.UserNotFoundException;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(User user) {
        externalApiRequest();
        //todo убрать
        user.setChangeTime(Instant.now());
        return userRepository.save(user).getId();
    }

    @Override
    public User getUser(Long id) {
        externalApiRequest();
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserStatusDto changeStatus(Long id, Boolean status) {
        externalApiRequest();
        User user = getUser(id);
        Boolean oldStatus = user.getStatus();
        user.setStatus(status);
        user.setChangeTime(Instant.now());
        userRepository.save(user);
        return new UserStatusDto(user, oldStatus);
    }

    //todo убрать
    @Override
    public List<User> findByStatusTimestamp(Boolean status, Instant timestamp) {
        return userRepository.findAllByStatusAndChangeTimeAfter(status, timestamp);
    }

    //todo убрать
    @Override
    public List<User> findAllByName(String name) {
        return userRepository.findAllByFirstName(name);
    }

    //todo убрать
    @Override
    public List<User> findAllByStatus(Boolean status) {
        return userRepository.findAllByStatus(status);
    }


    @Override
    public List<User> findAllByChangeTime(Instant changeTime) {
        ArrayList<User> list = new ArrayList<>(userRepository.findAllByChangeTime(changeTime));
        System.out.println("Okay");
        return userRepository.findAllByChangeTime(changeTime);
    }

    //todo раскомментить
    private void externalApiRequest(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
