package com.petroff.testtask.services;

import com.petroff.testtask.dto.StatisticDtoIn;
import com.petroff.testtask.dto.StatisticDtoOut;

public interface StatisticService {

    StatisticDtoOut getStatistic(StatisticDtoIn statisticDtoIn);

}
