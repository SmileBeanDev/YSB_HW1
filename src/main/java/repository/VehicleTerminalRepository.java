package repository;

import domain.VehicleTerminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTerminalRepository extends JpaRepository<VehicleTerminal, Long> {
}
