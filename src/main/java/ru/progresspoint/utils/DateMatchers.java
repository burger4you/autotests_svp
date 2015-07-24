package ru.progresspoint.utils;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.joda.time.DateTime;

public class DateMatchers {

    @Factory
    public static Matcher<DateTime> isBetween(String startDate, String endDate){
        return new DataTimeIsBetweenMatcher(startDate, endDate);
    }
}
