package com.petroff.testtask.controllers;

import com.petroff.testtask.dto.StatisticDtoOut;
import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import com.petroff.testtask.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @PostMapping
    public Long createUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping
    public UserStatusDto updateStatus(@PathParam("id") Long id, @PathParam("newStatus") Boolean newStatus) {
        return userService.changeStatus(id, newStatus);
    }

    @GetMapping("/findByST")
    public StatisticDtoOut getByST(@RequestParam(required = false) Boolean status, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime id) {
        return userService.findAllByStatusChangeTime(status, id);
    }

}
