# Date Time Lenient Parsing
### Supports Ordered Formats config using Java 8 LocalDateTime

# Getting Started
LocalDateTime parsing using DateTimeFormatterBuilder, DateTimeFormatter classes.

## Sample Curl request:
```
curl --request POST \
--url http://localhost:8080/case/date \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/8.6.1' \
--data '{
"inputFirstDateTime": "2024-02-28",
"inputSecondDateTime": "2024/Mar/07 02:02:45 am"
}'
```

## Sample Curl Response
```
{
    "inputFirstDateTime": "2024-02-28",
    "inputSecondDateTime": "2024/Mar/07 02:02:45 am",
    
    "parsedFirstDateInStandardJavaFormat": "2024-02-28T00:00:00",
    "parsedSecondDateInStandardJavaFormat": "2024-03-07T02:02:45",
    
    "periodDaysBetweenFirstSecondDates": 8,
    
    "periodDaysExpiredSinceFirstDate": 9,
    
    "sampleSupportedDates": [
        "2024-03-08 03:24:05 PM",
        "2024-03-08",
        "2024-Mar-08 03:24:05 PM",
        "2024/03/08 03:24:05 PM",
        "2024/03/08",
        "2024/Mar/08 03:24:05 PM",
        "2024.03.08 03:24:05 PM",
        "2024.03.08",
        "2024.Mar.08 03:24:05 PM"
    ]
}
```


<br><br>**********************

## Usage Guide Documentation
### COPY RELEVANT PACKAGE
Copy package content, rename package if required
  - com.example.*.dateparsing (except sub package demo) including files:

### COPY RELEVANT CLASSES
Classes to include
  - DateTimeParser (Interface)
    - DateTimeLenientParser
  - DateTimeConfigProperties
  - CustomDateTimeOrderedFormat

### WORKING
This is a Lenient date time parser without Zone support. This allows parsing for given date input string
into java 8 LocalDateTime. This tries to parse a given date matching each ordered format
and gets the first matched parsing to the user. Thus, the order is important.

In case of no match, this logs an eventual error message, else warnings, success logs are
printed.

DateTimeConfigProperties defines "custom.supportedDateTimeOrderedFormats"  

We have added default ordered formats in this enum "CustomDateTimeOrderedFormat"

This can be overridden by adding the property-   custom.supportedDateTimeOrderedFormats 
with comma separated values in the application yml/properties file or config.

### DEFAULT SUPPORTED FORMATS
Note here #STARTOFDAY is not standard date time format component
but just a custom component to add 00:00:00 time component in the 
output if the input has no time component.

If one doesn't include this, then any date only string input may 
not be correctly parsed in LocalDateTime object and may give null.
```
DATE_TIME_STANDARD_HYPHEN_12H("yyyy-MM-dd hh:mm:ss a"),
DATE_STANDARD_HYPHEN("yyyy-MM-dd#STARTOFDAY"),
DATE_TIME_STANDARD_EXT_HYPHEN_12H("yyyy-MMM-dd hh:mm:ss a"),

DATE_TIME_STANDARD_FWD_SLASH_12H("yyyy/MM/dd hh:mm:ss a"),
DATE_STANDARD_FWD_SLASH("yyyy/MM/dd#STARTOFDAY"),
DATE_TIME_STANDARD_EXT_FWD_SLASH_12H("yyyy/MMM/dd hh:mm:ss a"),

DATE_TIME_STANDARD_DOT_12H("yyyy.MM.dd hh:mm:ss a"),
DATE_STANDARD_DOT("yyyy.MM.dd#STARTOFDAY"),
DATE_TIME_STANDARD_EXT_DOT_12H("yyyy.MMM.dd hh:mm:ss a");
```
Thanks
