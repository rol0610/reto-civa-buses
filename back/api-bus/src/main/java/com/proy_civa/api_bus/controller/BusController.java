package com.proy_civa.api_bus.controller;

import com.proy_civa.api_bus.model.Bus;
import com.proy_civa.api_bus.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public Page<Bus> getBuses(Pageable pageable) {
        return busService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable Long id) {
        return busService.getById(id);
    }
}