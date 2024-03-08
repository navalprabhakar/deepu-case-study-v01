package com.example.deepucasestudyv01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class Test {
  public static void main(String[] args) {
    String dateTimeString = "2024-02-25 07:10:13 AM";

    // Define a custom DateTimeFormatter with the pattern including AM/PM marker
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd hh:mm:ss a")
            .parseCaseInsensitive().toFormatter().withLocale(Locale.ENGLISH);
        //DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a").;
    LocalDateTime parsedDateTime = null;
    // Parse the date-time string using LocalDateTime.parse and the custom formatter
    try {
      parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);
    } catch (Exception e) {
      e.printStackTrace();
        System.out.println(e.toString() + ": " + dateTimeString.charAt(17));
    }

    System.out.println("Parsed LocalDateTime: " + parsedDateTime);
    System.out.println(Locale.getDefault());
  }
}
