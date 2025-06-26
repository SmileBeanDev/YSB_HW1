//package service;
//
//import dev.smilebean.ysb_hw1.YsbHw1Application;
//import domain.*;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestConstructor;
//import repository.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = YsbHw1Application.class)
//@Transactional
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//class VehicleEventServiceTest {
//
//    private final VehicleEventRepository vehicleEventRepository;
//    private final VehicleRepository vehicleRepository;
//    private final EventRepository eventRepository;
//    private final VehicleRegionRepository vehicleRegionRepository;
//    private final VehicleTypeRepository vehicleTypeRepository;
//    private final VehicleTerminalRepository vehicleTerminalRepository;
//
//    public VehicleEventServiceTest(
//            VehicleEventRepository vehicleEventRepository,
//            VehicleRepository vehicleRepository,
//            EventRepository eventRepository,
//            VehicleRegionRepository vehicleRegionRepository,
//            VehicleTypeRepository vehicleTypeRepository,
//            VehicleTerminalRepository vehicleTerminalRepository
//    ) {
//        this.vehicleEventRepository = vehicleEventRepository;
//        this.vehicleRepository = vehicleRepository;
//        this.eventRepository = eventRepository;
//        this.vehicleRegionRepository = vehicleRegionRepository;
//        this.vehicleTypeRepository = vehicleTypeRepository;
//        this.vehicleTerminalRepository = vehicleTerminalRepository;
//    }
//
//    @Test
//    @DisplayName("VehicleEvent 튜플 2개 저장 후 조회")
//    void findAllVehicleEvents() {
//        // given
//        Event event1 = eventRepository.save(new Event(null, "졸음 운전"));
//        Event event2 = eventRepository.save(new Event(null, "휴대폰 사용"));
//
//        VehicleRegion region1 = vehicleRegionRepository.save(new VehicleRegion(null, "서울"));
//        VehicleType vehicleType1 = vehicleTypeRepository.save(new VehicleType(null, "마을버스"));
//
//        VehicleTerminal terminal1 = vehicleTerminalRepository.save(
//                new VehicleTerminal(null, "test1", "Online", LocalDateTime.now())
//        );
//        VehicleTerminal terminal2 = vehicleTerminalRepository.save(
//                new VehicleTerminal(null, "test2", "Online", LocalDateTime.now())
//        );
//
//        Vehicle vehicle1 = vehicleRepository.save(
//                new Vehicle(null, "서울0001", vehicleType1, region1, terminal1)
//        );
//        Vehicle vehicle2 = vehicleRepository.save(
//                new Vehicle(null, "서울0002", vehicleType1, region1, terminal2)
//        );
//
//        VehicleEvent vehicleEvent1 = new VehicleEvent(null, vehicle1, event1, LocalDateTime.now());
//        VehicleEvent vehicleEvent2 = new VehicleEvent(null, vehicle2, event2, LocalDateTime.now());
//
//        vehicleEventRepository.save(vehicleEvent1);
//        vehicleEventRepository.save(vehicleEvent2);
//
//        // when
//        List<VehicleEvent> vehicleEvents = vehicleEventRepository.findAll();
//
//        // then
//        assertEquals(2, vehicleEvents.size());
//    }
//
//    @Test
//    void findVehicleEventByNo() {
//        // TODO: 테스트 구현
//    }
//
//    @Test
//    void save() {
//        // TODO: 테스트 구현
//    }
//}
