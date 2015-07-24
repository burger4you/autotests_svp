package ru.progresspoint.utils;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import static org.joda.time.DateTime.parse;


class DataTimeIsBetweenMatcher extends TypeSafeMatcher<DateTime> {

    private final DateTime startDate;
    private final DateTime endDate;

    public DataTimeIsBetweenMatcher(final String startDate, final String endDate) {
        this.startDate = parse(startDate, dayMonthYear());
        this.endDate = parse(endDate, dayMonthYear());
    }

    public boolean matchesSafely(DateTime provided) {
        return (provided.isEqual(startDate) || provided.isAfter(startDate))
                && (provided.isEqual(endDate) || provided.isBefore(endDate));
    }

    public void describeTo(Description description) {
        description.appendText("a date that is between ");
        description.appendText(formatted(startDate));
        description.appendText(" and ");
        description.appendText(formatted(endDate));
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

    public static String formatted(DateTime dateTime) {
        return dateTime.toString("dd.MM.yyyy");
    }
}
