package com.example.wine;


import com.example.wine.Classes.Region;
import com.example.wine.Classes.Type;
import com.example.wine.Classes.Winery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(WineRepository wineRepository, RegionRepository regionRepository,
                                   WineryRepository wineryRepository, TypeRepository typeRepository) {

        return args -> {

            wineRepository.save(new Wine("Alto turia", 1999, 7,
                    3, 25, 99, 9,
                    regionRepository.save(new Region("Alto turia", "Valencia")),
                    typeRepository.save(new Type("Verdejo")),
                    wineryRepository.save(new Winery("Alto turia"))));

            wineRepository.findAll().forEach(wine -> log.info("Preloaded " + wine));


        };
    }

}