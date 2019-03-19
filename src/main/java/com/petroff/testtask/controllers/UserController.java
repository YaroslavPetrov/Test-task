package com.petroff.testtask.controllers;

import com.petroff.testtask.dto.UserStatusDto;
import com.petroff.testtask.model.User;
import com.petroff.testtask.repositories.UserRepository;
import com.petroff.testtask.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.Instant;
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

    @GetMapping("/findByStatusTimestamp")
    public List<User> getByStatusTimestamp(@PathParam("status") Boolean status, @PathParam("timestamp") @ModelAttribute Instant timestamp){
        return userService.findByStatusTimestamp(status, timestamp);
    }

    @GetMapping("/findByName")
    public List<User> getByName(@PathParam("name") String name){
        return userService.findAllByName(name);
    }

    @GetMapping("/findByStatus")
    public List<User> getByStatus(@PathParam("status") Boolean status){
        return userService.findAllByStatus(status);
    }

    @ModelAttribute
    Instant changeTime() {
        return Instant.now();
    }

    @GetMapping("/findByCT")
    public List<User> getByCT(@PathParam("changeTime") @ModelAttribute Instant changeTime){
        return userService.findAllByChangeTime(changeTime);
    }

}
