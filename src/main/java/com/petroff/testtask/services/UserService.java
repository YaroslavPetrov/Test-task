package com.petroff.testtask.services;

import com.petroff.testtask.dto.StatisticDtoOut;
import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;

import java.time.LocalDateTime;

public interface UserService {

    Long addUser(User user);

    User getUser(Long id);

    UserStatusDto changeStatus(Long id, Boolean status);

    StatisticDtoOut findAllByStatusChangeTime(Boolean status, LocalDateTime id);

}
