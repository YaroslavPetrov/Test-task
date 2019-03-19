package com.petroff.testtask.repositories;

import com.petroff.testtask.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByStatusAndChangeTimeAfter(Boolean status, Instant changeTime);

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByStatus(Boolean status);

    List<User> findAllByChangeTime(Instant changeTime);

}
