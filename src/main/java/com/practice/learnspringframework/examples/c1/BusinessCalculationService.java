package com.practice.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService(@Qualifier("MySQLQualifier") DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
