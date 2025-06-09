package dev.smilebean.ysb_hw1.repository;

import dev.smilebean.ysb_hw1.domain.VehicleTerminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTerminalRepository extends JpaRepository<VehicleTerminal, Long> {
}
