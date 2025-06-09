package repository;

import domain.VehicleRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRegionRepository extends JpaRepository<VehicleRegion, Long> {
}
