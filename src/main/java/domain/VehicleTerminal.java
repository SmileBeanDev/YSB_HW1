package domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="VEHICLE_TERMINAL")
public class VehicleTerminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(name="SERIAL", unique=true, length=30)
    private String serial;
    @Column(name="INSTALLED_DATE",nullable=false)
    private LocalDateTime installedDate;
    @Column(name="STATUS",nullable=false, length=30)
    private String status;
}
