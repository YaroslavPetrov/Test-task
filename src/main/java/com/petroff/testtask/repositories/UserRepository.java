package com.petroff.testtask.repositories;

import com.petroff.testtask.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByChangeTime(LocalDateTime changeTime);

}
