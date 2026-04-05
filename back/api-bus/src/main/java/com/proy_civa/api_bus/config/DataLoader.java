package com.proy_civa.api_bus.config;

import com.proy_civa.api_bus.model.Bus;
import com.proy_civa.api_bus.model.Marca;
import com.proy_civa.api_bus.repository.BusRepository;
import com.proy_civa.api_bus.repository.MarcaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(MarcaRepository marcaRepo, BusRepository busRepo) {
        return args -> {

            if (marcaRepo.count() == 0) {

                Marca volvo = new Marca();
                volvo.setNombre("Volvo");

                Marca scania = new Marca();
                scania.setNombre("Scania");

                marcaRepo.save(volvo);
                marcaRepo.save(scania);

                for (int i = 1; i <= 10; i++) {

                    Bus bus = new Bus();
                    bus.setNumeroBus(String.format("BUS-%03d", i));
                    bus.setPlaca("PLACA-" + (100 + i));
                    bus.setCaracteristicas("Bus generado automáticamente #" + i);
                    bus.setActivo(i % 2 == 0); // alterna activo/inactivo

                    // alternar marca
                    if (i % 2 == 0) {
                        bus.setMarca(volvo);
                    } else {
                        bus.setMarca(scania);
                    }

                    busRepo.save(bus);
                }
            }
        };
    }
}