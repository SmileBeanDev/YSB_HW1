package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name="VEHICLE_ID",nullable=false,unique=true,length = 50)
    private String vehicleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE_TYPE_NO")
    private VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VEHICLE_REGION_NO")
    private VehicleRegion vehicleRegion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VEHICLE_TERMINAL_NO")
    private VehicleTerminal vehicleTerminal;
}
