package com.example.deepucasestudyv01.dateparsing;

import lombok.Getter;

@Getter
public enum CustomDateTimeOrderedFormat {
  DATE_TIME_STANDARD_HYPHEN_12H("yyyy-MM-dd hh:mm:ss a"),
  DATE_STANDARD_HYPHEN("yyyy-MM-dd#STARTOFDAY"),
  DATE_TIME_STANDARD_EXT_HYPHEN_12H("yyyy-MMM-dd hh:mm:ss a"),

  DATE_TIME_STANDARD_FWD_SLASH_12H("yyyy/MM/dd hh:mm:ss a"),
  DATE_STANDARD_FWD_SLASH("yyyy/MM/dd#STARTOFDAY"),
  DATE_TIME_STANDARD_EXT_FWD_SLASH_12H("yyyy/MMM/dd hh:mm:ss a"),

  DATE_TIME_STANDARD_DOT_12H("yyyy.MM.dd hh:mm:ss a"),
  DATE_STANDARD_DOT("yyyy.MM.dd#STARTOFDAY"),
  DATE_TIME_STANDARD_EXT_DOT_12H("yyyy.MMM.dd hh:mm:ss a");

  private String format;

  private CustomDateTimeOrderedFormat(String format) {
    this.format = format;
  }
}
