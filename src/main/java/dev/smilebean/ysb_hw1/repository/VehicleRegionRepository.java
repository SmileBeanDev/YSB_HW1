package dev.smilebean.ysb_hw1.repository;

import dev.smilebean.ysb_hw1.domain.VehicleRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRegionRepository extends JpaRepository<VehicleRegion, Long> {
}
