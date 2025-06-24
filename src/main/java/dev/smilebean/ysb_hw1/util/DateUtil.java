package dev.smilebean.ysb_hw1.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
@Slf4j
public class DateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmss";
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final String ZONE_UTC = "UTC";
    public static final String ZONE_SEOUL = "Asia/Seoul";


    public ZonedDateTime getKorWeekFirstDay(int year, int week) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate date = LocalDate.now().withYear(year).with(weekFields.weekOfYear(), week).with(weekFields.dayOfWeek(),
                1);

        return date.atStartOfDay(ZoneId.of(ZONE_SEOUL));
    }


    public Date setUtc(Date date, Integer amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, amount);

        SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_FORMAT);
        String dateString = formatter.format(calendar.getTime());

        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            log.error("setUtc - 데이터 파싱 에러: " + e.getMessage());
            return null;
        }
    }

    public Date setUtc(Date date) {
        // 한국 시간은 UTC 보다 9시간 빠르다.
        return setUtc(date, -9);
    };
}
