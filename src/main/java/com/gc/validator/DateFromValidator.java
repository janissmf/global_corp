package com.gc.validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

public class DateFromValidator implements ConstraintValidator<DateFrom, Date> {

  private static final String DATE_FROM = "2015-01-01";

  @SneakyThrows
  @Override
  public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
    var dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(DATE_FROM);
    return !date.before(dateFrom);
  }
}
