package service;

import dto.VehicleEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VehicleEventRepository;

import java.util.List;

@Service
public class VehicleEventService {

    private final VehicleEventRepository vehicleEventRepository;

    public VehicleEventService(VehicleEventRepository vehicleEventRepository) {
        this.vehicleEventRepository = vehicleEventRepository;
    }

    public List<VehicleEventDTO> findAllVehicleEvents() {
        return null;
    }

    public VehicleEventDTO findVehicleEventByNo(Long no) {
        return null;
    }

    public VehicleEventDTO save(VehicleEventDTO vehicleEventDTO) {
        return null;
    }
}
