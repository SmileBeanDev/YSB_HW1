package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.dto.VehicleEventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.smilebean.ysb_hw1.service.VehicleEventService;

import java.util.List;

@RestController
@RequestMapping("api/vehicle-event")
public class VehicleEventController {
    private final VehicleEventService vehicleEventService;

    public VehicleEventController(VehicleEventService vehicleEventService) {
        this.vehicleEventService = vehicleEventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleEventDTO>> findAllVehicleEvents() {
        return ResponseEntity.ok(vehicleEventService.findAllVehicleEvents());
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleEventDTO>> findVehicleEventById(@RequestParam String vehicleId) {
        return ResponseEntity.ok(vehicleEventService.findVehicleEventByVehicleId(vehicleId));
    }

    // 리소스 중심의 REST API 는 동사형 URI 를 권장하지 않지만,
    // POST /api/vehicle-event 이 구조는 코드 확장(2개 이상의 POST 메서드)에 불리하다
    @PostMapping("/add")
    public ResponseEntity<String> addVehicleEvent(@RequestBody VehicleEventDTO vehicleEventDTO) {
        return ResponseEntity.ok(vehicleEventService.addVehicleEvent(vehicleEventDTO)); // 저장 완료 메시지로 바꾸기
    }
}
