package repository;

import domain.Vehicle;
import domain.VehicleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleEventRepository extends JpaRepository<VehicleEvent, Long> {
    public List<VehicleEvent> findByVehicle(Vehicle vehicle);
}
