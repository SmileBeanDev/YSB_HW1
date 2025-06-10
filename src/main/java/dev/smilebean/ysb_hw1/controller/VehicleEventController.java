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

    @GetMapping("/vehicle-id")
    public ResponseEntity<List<VehicleEventDTO>> findVehicleEventById(@RequestParam String vehicleId) {
        return ResponseEntity.ok(vehicleEventService.findVehicleEventByVehicleId(vehicleId));
    }

    // 리소스 중심의 설계방식 관점에서는 /event/save 보다 /event 가 더 적절함
    @PostMapping()
    public ResponseEntity<VehicleEventDTO> createVehicleEvent(@RequestBody VehicleEventDTO vehicleEventDTO) {
        VehicleEventDTO vehicleEvent = vehicleEventService.save(vehicleEventDTO);
        return ResponseEntity.ok(vehicleEvent);
    }
}
