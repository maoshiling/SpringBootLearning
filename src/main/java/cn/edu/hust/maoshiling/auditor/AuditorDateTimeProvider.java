package cn.edu.hust.maoshiling.auditor;

import org.springframework.data.auditing.DateTimeProvider;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by 15352 on 2017/4/13.
 */
public class AuditorDateTimeProvider implements DateTimeProvider {
    @Override
    public Calendar getNow() {
        return GregorianCalendar.from(ZonedDateTime.now());
    }
}
