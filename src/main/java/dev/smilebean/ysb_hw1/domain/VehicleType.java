package dev.smilebean.ysb_hw1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="VEHICLE_TYPE")
public class VehicleType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long no;

    @Column(name="VEHICLE_TYPE_NAME",nullable = false, length = 30)
    private String vehicleTypeName;
}
