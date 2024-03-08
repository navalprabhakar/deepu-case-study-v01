package com.example.deepucasestudyv01.dateparsing.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DateTimeResponse {
    private String inputFirstDateTime;
    private String inputSecondDateTime;
    private LocalDateTime parsedFirstDateInStandardJavaFormat;
    private LocalDateTime parsedSecondDateInStandardJavaFormat;
    private Long periodDaysBetweenFirstSecondDates;
    private Long periodDaysExpiredSinceFirstDate;

    private List<String> sampleSupportedDates;

  public static void main(String[] args) {
      LocalDate date = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
      String text = date.format(formatter);
      LocalDate parsedDate = LocalDate.parse(text, formatter);
  }

  public static void main2(String[] args) {
      String dateString = "2024-02-25 07:00:00";

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

      LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

      System.out.println(dateTime);
  }

  public static void main1(String[] args) {
      try {
          // Create two java.util.Date objects
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date date1 = sdf.parse("2016-02-25");
          Date date2 = sdf.parse("2024-03-05");

          // Convert java.util.Date objects to LocalDate
          LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

          // Calculate the difference in days
          long daysDifference = Duration.between(localDate1.atStartOfDay(), localDate2.atStartOfDay()).toDays();

          System.out.println("Number of days difference: " + daysDifference);
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }
}
