package com.petroff.testtask.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class StatisticDtoIn {

    private Instant id;
    private Boolean status;

    public StatisticDtoIn(Instant id, Boolean status) {
        this.id = id;
        this.status = status;
    }

}
