package com.example.wine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WineRepository wineshopRepository) {

        return args -> {
            wineshopRepository.save(new Wine());

            wineshopRepository.findAll().forEach(wineshop -> log.info("Preloaded " + wineshop));
        };
    }
}
