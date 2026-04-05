package com.proy_civa.api_bus.service;

import com.proy_civa.api_bus.model.Bus;
import com.proy_civa.api_bus.repository.BusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Page<Bus> getAll(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    public Bus getById(Long id) {
        return busRepository.findById(id).orElse(null);
    }
}