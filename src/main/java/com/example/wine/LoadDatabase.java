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
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean CommandLineRunner initDatabase(
      RegionRepository regionRepository,
      TypeRepository typeRepository,
      WineryRepository wineryRepository,
      WineRepository wineshopRepository) {

    return args -> {
      regionRepository.save(new Region("Alicante", "Espana"));
      regionRepository.save(new Region("Bierzo", "Espana"));
      regionRepository.save(new Region("Cadiz", "Espana"));

      regionRepository.findAll().forEach(r -> log.info("Preloaded " + r));

      typeRepository.save(new Type("Red"));
      typeRepository.save(new Type("Mencia"));
      typeRepository.save(new Type("Syrah"));

      typeRepository.findAll().forEach(t -> log.info("Preloaded: " + t));

      wineryRepository.save(new Winery("Losada"));
      wineryRepository.save(new Winery("Enrique Mendoza"));
      wineryRepository.save(new Winery("Huerta de Albala"));

      wineryRepository.findAll().forEach(winery -> log.info("Preloaded: " + winery));




      wineshopRepository.save(new Wine());

      wineshopRepository.findAll().forEach(wineshop -> log.info("Preloaded " + wineshop));
    };
  }
}
