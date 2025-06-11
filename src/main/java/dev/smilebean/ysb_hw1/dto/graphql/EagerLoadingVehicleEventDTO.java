package dev.smilebean.ysb_hw1.dto.graphql;

import dev.smilebean.ysb_hw1.domain.Event;
import dev.smilebean.ysb_hw1.domain.Vehicle;
import dev.smilebean.ysb_hw1.domain.VehicleEvent;
import dev.smilebean.ysb_hw1.dto.VehicleEventDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EagerLoadingVehicleEventDTO {
    private Long id;
    private String vehicleId;
    private String eventName;
    private String createdAt;

    public static VehicleEventDTO from(VehicleEvent vehicleEvent) {
        VehicleEventDTO dto = new VehicleEventDTO();
        dto.setNo(vehicleEvent.getNo());
        dto.setVehicleId(vehicleEvent.getVehicle().getVehicleId());
        dto.setEventName(vehicleEvent.getEvent().getEventName());
        dto.setCreatedAt(vehicleEvent.getCreatedAt().toString());
        return dto;
    }

    public VehicleEvent toEntity(Vehicle vehicle, Event event) {
        VehicleEvent vehicleEvent = new VehicleEvent();
        vehicleEvent.setVehicle(vehicle);
        vehicleEvent.setEvent(event);
        vehicleEvent.setCreatedAt(LocalDateTime.parse(this.createdAt)); // LocalDateTime 그대로 설정
        return vehicleEvent;
    }
}
