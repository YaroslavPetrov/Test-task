package com.petroff.testtask.services;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.exceptions.UserNotFoundException;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        user.setChangeTime(LocalDateTime.parse("2019-03-19T15:10:46.625"));
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
        user.setChangeTime(LocalDateTime.parse("2019-03-19T15:10:46.625"));
        userRepository.save(user);
        return new UserStatusDto(user, oldStatus);
    }

    @Override
    public List<User> findAllByChangeTime(LocalDateTime changeTime) {
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
