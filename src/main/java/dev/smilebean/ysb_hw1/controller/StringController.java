package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.util.StringUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class StringController {
    @GetMapping("/capitalize")
    public ResponseEntity<String> stringutil(@RequestParam String string) {
        String test = StringUtils.capitalize(string);
        return ResponseEntity.ok(test);
    }

    @GetMapping("/wildcard-to-escape")
    public ResponseEntity<String> hasLength(@RequestParam String string) {
        String test = StringUtils.hasLength(string) ? string
                .replaceAll("[%]","\\\\%")
                .replaceAll("[_]","\\\\\\_")
                .replaceAll("[']","\\\\'") : null;
        return ResponseEntity.ok(test);
    }

    @GetMapping("/build-mybatis-condition")
    public ResponseEntity<String> buildMybatisCondition(@RequestParam String field ,@RequestParam List<String> conditions) {
        boolean isAllNumeric = conditions.stream().allMatch(StringController::isNumeric);

        String resultSql = isAllNumeric
                ? StringUtil.getSqlConditionCollection(field, conditions)
                : StringUtil.getSqlStrConditionCollection(field, conditions);
            return ResponseEntity.ok(resultSql);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
