package com.petroff.testtask.services;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    Long addUser(User user);

    User getUser(Long id);

    UserStatusDto changeStatus(Long id, Boolean status);

    List<User> findAllByChangeTime(LocalDateTime changeTime);

}
