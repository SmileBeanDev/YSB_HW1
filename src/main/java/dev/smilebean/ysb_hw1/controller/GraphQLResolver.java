package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.dto.VehicleEventDTO;
import dev.smilebean.ysb_hw1.service.VehicleEventService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLResolver {
    private final VehicleEventService vehicleEventService;
    public GraphQLResolver(VehicleEventService vehicleEventService) {
        this.vehicleEventService = vehicleEventService;
    }

    @QueryMapping
    public List<VehicleEventDTO> allVehicleEvents() {
        return vehicleEventService.findAllVehicleEvents();
    }

    @QueryMapping
    public List<VehicleEventDTO> vehicleEventsByVehicleId(@Argument String vehicleId) {
        return vehicleEventService.findVehicleEventByVehicleId(vehicleId);
    }

    @MutationMapping
    public String addVehicleEvent(@Argument("input") VehicleEventDTO vehicleEventDTO) {
        return vehicleEventService.addVehicleEvent(vehicleEventDTO);
    }
}
