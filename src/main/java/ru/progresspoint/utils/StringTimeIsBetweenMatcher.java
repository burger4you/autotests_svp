package ru.progresspoint.utils;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import static net.thucydides.core.matchers.dates.DateMatchers.isAfter;
import static org.joda.time.DateTime.parse;


public class StringTimeIsBetweenMatcher {

    public static Matcher<String> after(final DateTime startDate) {
        return new FeatureMatcher<String, DateTime>(isAfter(startDate), "string same as", "string -") {
            @Override
            protected DateTime featureValueOf(String s) {
                return parse(s);
            }
        };
    }

//    public static DateTimeFormatter dayMonthYearHourMinute() {
//        return new DateTimeFormatterBuilder()
//                .appendDayOfMonth(2)
//                .appendLiteral('.')
//                .appendMonthOfYear(2)
//                .appendLiteral('.')
//                .appendYear(4, 4)
//                .appendLiteral(' ')
//                .appendHourOfDay(2)
//                .appendLiteral(':')
//                .appendMinuteOfHour(2)
//                .toFormatter();
//    }

    public static DateTimeFormatter dayMonthYearHourMinute() {
        return new DateTimeFormatterBuilder()
                .appendYear(4, 4)
                .appendLiteral('-')
                .appendMonthOfYear(2)
                .appendLiteral('-')
                .appendDayOfMonth(2)
                .appendLiteral(' ')
                .appendHourOfDay(2)
                .appendLiteral(':')
                .appendMinuteOfHour(2)
                .toFormatter();
    }

    public static DateTimeFormatter dayMonthYear() {
        return new DateTimeFormatterBuilder()
                .appendDayOfMonth(2)
                .appendLiteral('.')
                .appendMonthOfYear(2)
                .appendLiteral('.')
                .appendYear(4, 4)
                .toFormatter();
    }
}
