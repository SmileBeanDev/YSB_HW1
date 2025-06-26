package dev.smilebean.ysb_hw1.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/stream")
public class StreamController {
    @GetMapping("/students-grouping-by-sex")
    public ResponseEntity<String> groupingBySex() {


        List<Student> students = Arrays.asList(
                new Student("성우", 28, "남자"),
                new Student("한솔", 31, "여자"),
                new Student("규래", 29, "남자"),
                new Student("정아", 24, "여자")
        );

        Map<String, List<Student>> studentsGroupingBySex = students.stream().collect(Collectors.groupingBy(Student::getSex));

        Map<String, List<Student>> studentsGroupingBySexHashMap = students.stream().collect(Collectors.groupingBy(student -> student.getSex(), HashMap::new, Collectors.toList()));
        // student -> student.getSex() : 분류 기준
        // HashMap::new : groupingBy 의 반환값은 순서가 보장된 LinkedHashMap 인데, 그 반환값을 HashMap 으로 하기 위함
        // Collectors.toList() : 각 그룹의 value 타입을 List<> 로 모으겠다.
        StringBuilder result = new StringBuilder();
        students.stream().collect(Collectors.groupingBy(student -> student.getSex(), HashMap::new, Collectors.toList())).forEach(
                (key, value) -> {
                    switch (key) {
                        case "남자" : for(Student student : value) { result.append(student.name).append("(은)는 남자입니다.");}
                        break;
                        case "여자" : for(Student student : value) { result.append(student.name).append("(은)는 여자입니다.");}
                        break;
                    }
                }
        );
        System.out.println(studentsGroupingBySex);
        System.out.println(studentsGroupingBySexHashMap);
        return ResponseEntity.ok(result.toString());
    }

    @GetMapping("/distinct-students")
    public ResponseEntity<String> getDistinctStudents() {
        List<Student> students = Arrays.asList(
                new Student("종우", 28, "남자"),
                new Student("종우", 28, "남자"),
                new Student("지혜", 29, "여자"),
                new Student("지혜", 29, "여자")
        );

        List<Student> distinctStudents = students.stream().distinct().collect(Collectors.toList());
        return ResponseEntity.ok(distinctStudents.toString());
    }

    @GetMapping("/intstream/instream-range-closed")
    public ResponseEntity<String> getInstreamRangeClosed() {
        List<String> janToDec = IntStream
                .rangeClosed(1,12)
                .mapToObj(integer -> String.format("%d월", integer))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        for (String mon : janToDec) {
            result.append(mon).append("\n");
        }

        return ResponseEntity.ok(result.toString());
    }

    @Data
    static class Student {
        String name;
        int age;
        String sex;

        Student(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    }
}