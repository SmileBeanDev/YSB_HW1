package dev.smilebean.ysb_hw1.repository;

import dev.smilebean.ysb_hw1.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVehicleId(String vehicleId);
}
