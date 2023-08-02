package com.practice.learnspringframework.examples.c1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MySQLQualifier")
public class MySQLDataService implements DataService {
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }
}
