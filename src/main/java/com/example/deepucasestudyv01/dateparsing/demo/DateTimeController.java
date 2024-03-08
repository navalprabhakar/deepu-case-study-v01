package com.example.deepucasestudyv01.dateparsing.demo;

import com.example.deepucasestudyv01.dateparsing.DateTimeParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class DateTimeController {

  @Autowired private DateTimeParser dateTimeParser;

  @GetMapping("/date")
  public ResponseEntity<Object> date(@RequestParam("inputDateTime") String inputDateTime)
      throws JsonProcessingException {
    LocalDateTime parsedDate = dateTimeParser.fromDateTime(inputDateTime);
    DateTimeResponse dateTimeResponse = new DateTimeResponse();
    dateTimeResponse.setInputFirstDateTime(inputDateTime);
    dateTimeResponse.setParsedFirstDateInStandardJavaFormat(parsedDate);
    dateTimeResponse.setSampleSupportedDates(dateTimeParser.sampleSupportedDates());

    log.info("dateResponse- {}", dateTimeResponse.toString());
    return ResponseEntity.accepted().body(dateTimeResponse);
  }

  @PostMapping("/date")
  public ResponseEntity<Object> date(@RequestBody DateTimeInput dateTimeInput)
      throws JsonProcessingException {
    DateTimeResponse dateTimeResponse = new DateTimeResponse();
    dateTimeResponse.setInputFirstDateTime(dateTimeInput.getInputFirstDateTime());
    dateTimeResponse.setInputSecondDateTime(dateTimeInput.getInputSecondDateTime());

    try {
      parseDatesAndPeriods(dateTimeInput, dateTimeResponse);
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body(dateTimeResponse);
    }
    return ResponseEntity.accepted().body(dateTimeResponse);
  }

  private void parseDatesAndPeriods(
      DateTimeInput dateTimeInput, DateTimeResponse dateTimeResponse) {
    LocalDateTime parsedFirstDate =
        dateTimeParser.fromDateTime(dateTimeInput.getInputFirstDateTime());
    LocalDateTime parsedSecondDate =
        dateTimeParser.fromDateTime(dateTimeInput.getInputSecondDateTime());

    dateTimeResponse.setParsedFirstDateInStandardJavaFormat(parsedFirstDate);
    dateTimeResponse.setParsedSecondDateInStandardJavaFormat(parsedSecondDate);

    dateTimeResponse.setPeriodDaysBetweenFirstSecondDates(
        dateTimeParser.periodDaysBetween(parsedFirstDate, parsedSecondDate));

    dateTimeResponse.setPeriodDaysExpiredSinceFirstDate(
        dateTimeParser.periodDaysExpiredBy(parsedFirstDate));

    dateTimeResponse.setSampleSupportedDates(dateTimeParser.sampleSupportedDates());
    log.info("dateResponse- {}", dateTimeResponse.toString());
  }
}
