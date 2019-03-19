package com.petroff.testtask.services;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;

import java.time.Instant;
import java.util.List;

public interface UserService {

    Long addUser(User user);

    User getUser(Long id);

    UserStatusDto changeStatus(Long id, Boolean status);

    List<User> findByStatusTimestamp(Boolean status, Instant timestamp);

    List<User> findAllByName(String name);

    List<User> findAllByStatus(Boolean status);

    List<User> findAllByChangeTime(Instant changeTime);

}
