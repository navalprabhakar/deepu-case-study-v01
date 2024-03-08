package com.example.deepucasestudyv01.dateparsing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "custom")
@Data
@AllArgsConstructor
public class DateTimeConfigProperties {

  private List<String> supportedDateTimeOrderedFormats;

  public DateTimeConfigProperties() {
    supportedDateTimeOrderedFormats = new ArrayList<>();
    Arrays.stream(CustomDateTimeOrderedFormat.values())
        .forEach(cdf -> supportedDateTimeOrderedFormats.add(cdf.getFormat()));
  }
}
