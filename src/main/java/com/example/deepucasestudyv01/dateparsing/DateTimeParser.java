package com.example.deepucasestudyv01.dateparsing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DateTimeParser {
    LocalDateTime fromDateTime(String inputDate);

    long periodDaysBetween(LocalDate firstDate, LocalDate secondDate);

    long periodDaysBetween(LocalDateTime firstDate, LocalDateTime secondDate);

    long periodDaysBetween(String firstDate, String secondDate);

    long periodDaysExpiredBy(LocalDateTime eventDate);

    long periodDaysExpiredBy(String eventDate);

    List<String> sampleSupportedDates();
}
