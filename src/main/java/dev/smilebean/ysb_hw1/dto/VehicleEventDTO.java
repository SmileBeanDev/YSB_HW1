package dev.smilebean.ysb_hw1.dto;

import dev.smilebean.ysb_hw1.domain.Event;
import dev.smilebean.ysb_hw1.domain.Vehicle;
import dev.smilebean.ysb_hw1.domain.VehicleEvent;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class VehicleEventDTO {
    private Long no;
    private String vehicleId;
    private String eventName;
    private String createdAt;
    // BIGINTEGER VS LONG
    // MariaDB 의 BigInteger : 64 비트의 정수 표현 가능 -2^63 ~ 2^63 -1
    // 자바의 long : 64 비트 정수 표현 가능
    // 자바의 BigInteger : 무제한에 가까운 수를 표현할 떄 사용하고, MariaDB 의 Decimal , Numeric 에 대응
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
