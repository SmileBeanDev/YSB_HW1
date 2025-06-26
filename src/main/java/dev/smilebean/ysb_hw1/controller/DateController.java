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
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
    public ResponseEntity<String> getKorWeekFirstDay(@RequestParam int year, @RequestParam int week) {
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
            String dateString = date.toString().replace("KST", "");
            return ResponseEntity.ok(dateString);
        } catch (ParseException e) {
            log.error("controller - 입력 받은거 날짜 형식 이상해: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("show")
    public ResponseEntity<String> whatIsDate(@RequestParam String date) {
        StringBuilder result = new StringBuilder();
        // Date - SimpleDateFormat - 옜날 것임, 레거시임
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = sdf.parse(date);
            result.append("java.util.Date: ").append(sdf.format(parsedDate)).append("\n");
        } catch (ParseException e) {
            result.append("Date 파싱 실패: ").append(e.getMessage()).append("\n");
        }

        // LocalDate : yyyy-MM-dd 형식
        try {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
            result.append("java.time.LocalDate: ").append(localDate).append("\n");
        } catch (DateTimeParseException e) {
            result.append("LocalDate 파싱 실패: ").append(e.getMessage()).append("\n");
        }

        // LocalDateTime : yyyy-MM-dd hh:mm:ss 형식
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            result.append("java.time.LocalDateTime: ").append(localDateTime).append("\n");
        } catch (DateTimeParseException e) {
            result.append("LocalDateTime 파싱 실패: ").append(e.getMessage()).append("\n");
        }

        // ZonedDateTime : LocalDateTime + Time Zone
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Seoul"));
            result.append("java.time.ZonedDateTime(KST): ").append(zonedDateTime).append("\n");
            zonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
            result.append("java.time.ZonedDateTime(UTC): ").append(zonedDateTime).append("\n");
        } catch (DateTimeParseException e) {
            result.append("ZonedDateTime 파싱 실패: ").append(e.getMessage()).append("\n");
        }
        return ResponseEntity.ok(result.toString());
    }

    @GetMapping("to-string")
    public ResponseEntity<String> dateToString(@RequestParam String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = sdf.parse(date);
            String reParsedDate = sdf.format(parsedDate);
            return ResponseEntity.ok(reParsedDate + " is a String");
        } catch (ParseException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
