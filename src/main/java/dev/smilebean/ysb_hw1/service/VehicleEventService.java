package dev.smilebean.ysb_hw1.service;

import dev.smilebean.ysb_hw1.domain.Event;
import dev.smilebean.ysb_hw1.domain.Vehicle;
import dev.smilebean.ysb_hw1.domain.VehicleEvent;
import dev.smilebean.ysb_hw1.dto.VehicleEventDTO;
import org.springframework.stereotype.Service;
import dev.smilebean.ysb_hw1.repository.EventRepository;
import dev.smilebean.ysb_hw1.repository.VehicleEventRepository;
import dev.smilebean.ysb_hw1.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleEventService {
    // 차량에서 발생한 이벤트를 CRUD 하기 위해 필요한 의존성 ( 차량, 이벤트, 발생 이벤트 내역 )
    private final VehicleEventRepository vehicleEventRepository;
    private final VehicleRepository vehicleRepository;
    private final EventRepository eventRepository;


    public VehicleEventService(VehicleEventRepository vehicleEventRepository, VehicleRepository vehicleRepository, EventRepository eventRepository) {
        this.vehicleEventRepository = vehicleEventRepository;
        this.vehicleRepository = vehicleRepository;
        this.eventRepository = eventRepository;
    }

    public List<VehicleEventDTO> findAllVehicleEvents() {
        // 모든 발생한 이벤트 내역을 조회
        List<VehicleEvent> vehicleEvents = vehicleEventRepository.findAll();

        return convertToDTO(vehicleEvents);
    }

    public List<VehicleEventDTO> findVehicleEventByVehicleId(String vehicleId) {
        // 차량번호로 이벤트 발생 내역 조회
        List<VehicleEvent> vehicleEvents = vehicleEventRepository.findByVehicleId(vehicleId);

        return convertToDTO(vehicleEvents);
    }

    public VehicleEventDTO save(VehicleEventDTO vehicleEventDTO) {
        // 차량 번호 조회
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleEventDTO.getVehicleId());

        // 이벤트 명 조회
        Event event = eventRepository.findByEventName(vehicleEventDTO.getEventName());

        // 조회한 차량 번호에 이벤트 추가
        VehicleEvent vehicleEvent = vehicleEventDTO.toEntity(vehicle, event);

        // DB 저장하고 응답용 DTO 반환
        VehicleEvent saved = vehicleEventRepository.save(vehicleEvent);
        return VehicleEventDTO.from(saved);
    }

    public List<VehicleEventDTO> convertToDTO(List<VehicleEvent> vehicleEvents) {
        // DTO 로 변환하기 위해 배열 생성
        List<VehicleEventDTO> vehicleEventDTOs = new ArrayList<>();

        // 조회된 이벤트 내역을 DTO 로 변환하고 반환
        for (VehicleEvent vehicleEvent : vehicleEvents) {
            vehicleEventDTOs.add(VehicleEventDTO.from(vehicleEvent));
        }
        return vehicleEventDTOs;
    }
}
