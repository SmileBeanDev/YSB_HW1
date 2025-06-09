package dev.smilebean.ysb_hw1.repository;

import dev.smilebean.ysb_hw1.domain.Vehicle;
import dev.smilebean.ysb_hw1.domain.VehicleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleEventRepository extends JpaRepository<VehicleEvent, Long> {
    public List<VehicleEvent> findByVehicle(Vehicle vehicle);

    @Query("SELECT ve FROM VehicleEvent ve WHERE ve.vehicle.vehicleId = :vehicleId")
    public List<VehicleEvent> findByVehicleId(@Param("vehicleId") String vehicleId);
}
