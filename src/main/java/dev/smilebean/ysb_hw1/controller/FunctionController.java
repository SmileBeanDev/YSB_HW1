package dev.smilebean.ysb_hw1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;

import static java.time.format.TextStyle.SHORT;

@RestController
@RequestMapping("function")
public class FunctionController {
    @GetMapping("simple")
    public String simple(@RequestParam String input) {
        return "output";
    }

    public enum DateType {
        DAY(eventTime -> String.valueOf(Math.floorDiv(getEventTimePick(eventTime,"HH"),4)));

        private final Function<String, String> function;

        DateType(Function<String, String> function) {
            this.function = function;
        }

        public static Integer getEventTimePick(Object eventTime, String format) {
            return Integer.parseInt(LocalDateTime.parse(String.valueOf(eventTime), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    .format(DateTimeFormatter.ofPattern(format)));
        }
    }
}
