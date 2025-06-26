package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.mapper.FoodItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("function")
public class FunctionController {
    @Autowired
    private FoodItemsMapper foodItemsMapper;

    @GetMapping("divide-hour-by-4")
    public String simple(@RequestParam String date) {
        return  DateType.DAY.function.apply(date);
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

    @GetMapping("mybatis-output-map")
    public ResponseEntity<String> mybatisOutputMap() {

        List<Map<String, Object>> data = foodItemsMapper.getFoodItems();

        List<Map> filterData = data.stream().filter(item -> FoodGroup.FISH.foods.stream().anyMatch(match -> Integer.valueOf(item.get(match).toString()) >0 )).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : data) {
            sb.append(map).append("\n");
        }
        return ResponseEntity.ok(sb.toString());
        // { column1 : val1 , column2 : val2 , ... } => Map<String,Object> row = new HashMap<>(); row.put(column1,val1) ...
    }

    public enum FoodGroup {
        FISH(Arrays.asList("농어 소금 오븐 구이","볼락 화로 구이","대구 튀김과 감자튀김","연어 스테이크","송어 숯불 구이")),
        MEAT(Arrays.asList("안심 스테이크", "살치살 스테이크", "안창살 꽂이 구이", "돼지 갈비 구이","풀드포크","양 갈비 스테이크")),
        DRINK(Arrays.asList("콜라","사이다","데낄라","모히또","맥주","위스키","레드 와인","화이트 와인"));
        private List<String> foods;

        FoodGroup(List<String> foods) {
            this.foods = foods;
        }
    }
}
