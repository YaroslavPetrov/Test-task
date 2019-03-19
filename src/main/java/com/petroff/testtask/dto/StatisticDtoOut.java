package com.petroff.testtask.dto;

import com.petroff.testtask.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class StatisticDtoOut {

    private Instant id;
    private List<User> users;

    public StatisticDtoOut(Instant id, List<User> users) {
        this.id = id;
        this.users = users;
    }
}
