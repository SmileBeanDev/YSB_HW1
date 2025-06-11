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
//    @Query("SELECT ve FROM VehicleEvent ve WHERE ve.vehicle.vehicleId = :vehicleId")
    // 굳이 ORM 을 쓴다면 단순한 쿼리는 직접입력을 지양하기, 복잡한 쿼리인 경우 가능 (ORM의 컨벤션)
    // ORM 철학 : 필드가 바뀌어도, 자동 반영되는 유지 보수성, 쿼리에 신경 덜 쓰고 비즈니스 로직 설계에 집중
    // public List<VehicleEvent> findByVehicle_VehicleId(String vehicleId); 이게 더 좋음
    public List<VehicleEvent> findByVehicle_VehicleId(String vehicleId);
}
