package dto;

import domain.Event;
import domain.Vehicle;
import domain.VehicleEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleEventDTO {
    private String vehicleId;
    private String eventName;
    private String createdAt;

    public static VehicleEventDTO from(VehicleEvent vehicleEvent) {
        VehicleEventDTO dto = new VehicleEventDTO();
        dto.vehicleId = vehicleEvent.getVehicle().getVehicleId();
        dto.eventName = vehicleEvent.getEvent().getEventName();
        dto.createdAt = vehicleEvent.getCreatedAt().toString();
        return dto;
    }

    public VehicleEvent toEntity(Vehicle vehicle, Event event) {
        VehicleEvent vehicleEvent = new VehicleEvent();
        vehicleEvent.setVehicle(vehicle);
        vehicleEvent.setEvent(event);
        vehicleEvent.setCreatedAt(LocalDateTime.parse(this.createdAt));

        return vehicleEvent;
    }
}
