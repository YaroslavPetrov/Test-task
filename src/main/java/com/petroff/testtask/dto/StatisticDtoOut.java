package com.petroff.testtask.dto;

import com.petroff.testtask.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StatisticDtoOut {

    private LocalDateTime id;
    private Iterable<User> users;

    public StatisticDtoOut(LocalDateTime id, Iterable<User> users) {
        this.id = id;
        this.users = users;
    }
}
