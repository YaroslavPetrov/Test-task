package com.petroff.testtask.services;

import com.petroff.testtask.dto.StatisticDtoOut;
import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.exceptions.UserNotFoundException;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(User user) {
        externalApiRequest();
        user.setChangeTime(LocalDateTime.now());
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
        user.setChangeTime(LocalDateTime.now());
        userRepository.save(user);
        return new UserStatusDto(user, oldStatus);
    }

    @Override
    public StatisticDtoOut findAllByStatusChangeTime(Boolean status, LocalDateTime id) {
        if (id != null && status != null) {
            return new StatisticDtoOut(LocalDateTime.now(), userRepository.findAllByStatusAndChangeTimeAfter(status, id));
        } else if (status != null) {
            return new StatisticDtoOut(LocalDateTime.now(), userRepository.findAllByStatus(status));
        } else {
            return new StatisticDtoOut(LocalDateTime.now(), userRepository.findAll());
        }
    }


    private void externalApiRequest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
