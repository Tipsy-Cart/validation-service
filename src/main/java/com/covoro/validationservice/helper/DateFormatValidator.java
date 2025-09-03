package com.covoro.validationservice.helper;

import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateFormatValidator implements Format {

    private static final String NAME = "YYYY-MM-DD";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean matches(ExecutionContext executionContext, String value) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(value, dtf);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
