package com.petroff.testtask.controllers;

import com.petroff.testtask.dto.StatisticDtoIn;
import com.petroff.testtask.dto.StatisticDtoOut;
import com.petroff.testtask.services.StatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Statistic")
public class StatisticController {

    private final StatisticServiceImpl statisticService;

    @Autowired
    public StatisticController(StatisticServiceImpl statisticService) {
        this.statisticService = statisticService;
    }

    @PostMapping
    public StatisticDtoOut getStatistic(@RequestBody StatisticDtoIn statisticDtoIn){
        return statisticService.getStatistic(statisticDtoIn);
    }

}
