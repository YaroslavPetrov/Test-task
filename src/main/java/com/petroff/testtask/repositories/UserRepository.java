package com.petroff.testtask.repositories;

import com.petroff.testtask.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findAllByStatusAndChangeTimeAfter(Boolean status, LocalDateTime changeTime);

    Iterable<User> findAllByStatus(Boolean status);

}
