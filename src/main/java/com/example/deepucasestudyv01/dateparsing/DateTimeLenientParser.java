package com.example.deepucasestudyv01.dateparsing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
@Slf4j
public class DateTimeLenientParser implements DateTimeParser {

  private DateTimeConfigProperties dateTimeConfigProperties;

  private List<DateTimeFormatter> supportedDateFormats;

  private String regexOptionalTimeStartOfDay = "#STARTOFDAY";

  public DateTimeLenientParser(DateTimeConfigProperties dateTimeConfigProperties) {
    this.dateTimeConfigProperties = dateTimeConfigProperties;
    supportedDateFormats =
        this.dateTimeConfigProperties.getSupportedDateTimeOrderedFormats().stream()
            .map(
                (f) -> {
                  DateTimeFormatterBuilder builder =
                      new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient();
                  if (f.contains(regexOptionalTimeStartOfDay)) {
                    builder =
                        builder
                            .appendPattern(f.replaceAll(regexOptionalTimeStartOfDay, ""))
                            .optionalStart()
                            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                            .optionalEnd();
                  } else {
                    builder = builder.appendPattern(f);
                  }
                  return builder.toFormatter().withLocale(Locale.ENGLISH);
                })
            .collect(Collectors.toList());
  }

  @Override
  public LocalDateTime fromDateTime(String inputDate) {
    LocalDateTime parsedDate = null;

    for (DateTimeFormatter priorityDateFormat : supportedDateFormats) {
      try {
        parsedDate = LocalDateTime.parse(inputDate, priorityDateFormat);
        log.info("Successfully parsed date input- {} as {}", inputDate, parsedDate);
        break;
      } catch (DateTimeParseException dateTimeParseException) {
        log.warn(
            "Warn: Input date {} has parsing error [{}]- Checked format {}",
            inputDate,
            dateTimeParseException.getMessage(),
            priorityDateFormat);
      }
    }
    if (parsedDate == null) {
      log.error("Error: Input date {} parsing failed completely", inputDate);
    }
    return parsedDate;
  }

  public List<String> sampleSupportedDates() {
    List<String> sampleDates = new ArrayList<>();
    LocalDateTime now = null;
    for (DateTimeFormatter priorityDateFormat : supportedDateFormats) {
      try {
        now = LocalDateTime.now();
        sampleDates.add(now.format(priorityDateFormat));
      } catch (DateTimeParseException dateTimeParseException) {
        log.error(
            "Input date {} format {} parsing error",
            now,
            priorityDateFormat.toString(),
            dateTimeParseException);
      }
    }
    return sampleDates;
  }

  @Override
  public long periodDaysBetween(LocalDate firstDate, LocalDate secondDate) {
    long periodDays = DAYS.between(firstDate, secondDate);
    log.info(
        "Successfully calculated period days between date inputs- {}, {} as {}",
        firstDate,
        secondDate,
        periodDays);
    return periodDays;
  }

  @Override
  public long periodDaysBetween(LocalDateTime firstDate, LocalDateTime secondDate) {
    long periodDays = DAYS.between(firstDate.toLocalDate(), secondDate.toLocalDate());
    log.info(
        "Successfully calculated period days between date inputs- {}, {} as {}",
        firstDate,
        secondDate,
        periodDays);
    return periodDays;
  }

  @Override
  public long periodDaysBetween(String firstDate, String secondDate) {
    long periodDays =
            DAYS.between(
                this.fromDateTime(firstDate).toLocalDate(),
                this.fromDateTime(secondDate).toLocalDate());
    log.info(
        "Successfully calculated period days between date inputs- {}, {} as {}",
        firstDate,
        secondDate,
        periodDays);
    return periodDays;
  }

  @Override
  public long periodDaysExpiredBy(LocalDateTime eventDate) {
    long expiredByDays =
        this.periodDaysBetween(eventDate.toLocalDate(), LocalDateTime.now().toLocalDate());
    log.info(
        "Successfully calculated period days expired by since date input- {} as {}",
        eventDate,
        expiredByDays);
    return expiredByDays;
  }

  @Override
  public long periodDaysExpiredBy(String eventDate) {
    long expiredByDays =
        this.periodDaysBetween(this.fromDateTime(eventDate).toLocalDate(), LocalDate.now());
    log.info(
        "Successfully calculated period days expired by since date input- {} as {}",
        eventDate,
        expiredByDays);
    return expiredByDays;
  }
}
