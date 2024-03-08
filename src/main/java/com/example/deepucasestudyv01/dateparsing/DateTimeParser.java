package com.example.deepucasestudyv01.dateparsing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DateTimeParser {
    LocalDateTime fromDateTime(String inputDate);

    int periodDaysBetween(LocalDate firstDate, LocalDate secondDate);

    int periodDaysBetween(LocalDateTime firstDate, LocalDateTime secondDate);

    int periodDaysBetween(String firstDate, String secondDate);

    int periodDaysExpiredBy(LocalDateTime eventDate);

    int periodDaysExpiredBy(String eventDate);

    List<String> sampleSupportedDates();
}
