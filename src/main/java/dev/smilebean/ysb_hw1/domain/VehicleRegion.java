package dev.smilebean.ysb_hw1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Vehicle_Region")
public class VehicleRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "REGION_NAME", length = 30)
    private String regionName;
}
