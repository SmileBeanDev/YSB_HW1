package dev.smilebean.ysb_hw1.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="VEHICLE_EVENT")
public class VehicleEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VEHICLE_NO")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EVENT_NO")
    private Event event;

    @Column(name="CREATED_AT",nullable = false)
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "VehicleEvent [no=" + no + ", vehicleClass=" + vehicle.getClass() + ", eventClass=" + event.getClass() + ", createdAt=" + createdAt;
    }
}
