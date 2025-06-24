package dev.smilebean.ysb_hw1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
