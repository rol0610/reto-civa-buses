package com.proy_civa.api_bus.repository;

import com.proy_civa.api_bus.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}