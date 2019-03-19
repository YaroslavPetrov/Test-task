package com.petroff.testtask.controllers;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import com.petroff.testtask.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

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

    @ModelAttribute
    LocalDateTime changeTime() {
        return LocalDateTime.parse("2019-03-19T15:10:46.625");
    }

    @GetMapping("/findByCT")
    public List<User> getByCT(@PathParam("changeTime") @ModelAttribute LocalDateTime changeTime){
        return userService.findAllByChangeTime(changeTime);
    }

}
