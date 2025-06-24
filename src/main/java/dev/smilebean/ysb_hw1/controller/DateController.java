package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@RestController
@RequestMapping("/date")
@Slf4j
public class DateController {

    @Autowired
    private final DateUtil dateUtil;

    public DateController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping("get-korean-week-first-day")
    public ResponseEntity<String> getKorWeekFirstDay(@RequestParam int year,@RequestParam int week) {
        return ResponseEntity.ok(dateUtil.getKorWeekFirstDay(year, week).toString());
    }


    // 한국은 UTC + 9
    @GetMapping("convert-to-utc")
    public ResponseEntity<String> setUtc(@RequestParam String string) {
        SimpleDateFormat formatterKst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // KST 로 입력 받음
        try {
            Date date = formatterKst.parse(string);
            System.out.println(date);
            date = dateUtil.setUtc(date);
            // UTC 로 변환함
            String dateString = date.toString().replace("KST","");
            return ResponseEntity.ok(dateString);
        } catch (ParseException e) {
            log.error("controller - 입력 받은거 날짜 형식 이상해: " + e.getMessage());
            return null;
        }
    }
}
