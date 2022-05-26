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


  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean CommandLineRunner initDatabase(
      RegionRepository regionRepository,
      TypeRepository typeRepository,
      WineryRepository wineryRepository,
      WineRepository wineshopRepository) {

    return args -> {
      Region alicante = new Region("Alicante", "Espana");
      Region bierzo   = new Region("Bierzo", "Espana");
      Region cadiz    = new Region("Cadiz", "Espana");

      Type red    = new Type("Red");
      Type mencia = new Type("Mencia");
      Type syrah  = new Type("Syrah");

      Winery losada          = new Winery("Losada");
      Winery enrique_mendoza = new Winery("Enrique Mendoza");
      Winery albala          = new Winery("Huerta de Albala");

      Wine wine1 = new Wine("Santa Rosa", 2017, 42f, 420, 189, 4, 3);
      alicante.addWine(wine1);
      red.addWine(wine1);
      albala.addWine(wine1);

      Wine wine2 = new Wine("Altos de Losada", 2018, 42f, 415, 179, 4, 3);
      bierzo.addWine(wine2);
      mencia.addWine(wine2);
      losada.addWine(wine2);


      Wine wine3 = new Wine("Tintilla de Rota", 2016, 46f, 92, 47, 4, 3);
      cadiz.addWine(wine3);
      syrah.addWine(wine3);
      enrique_mendoza.addWine(wine3);


      regionRepository.save(alicante);
      regionRepository.save(bierzo);
      regionRepository.save(cadiz);

      typeRepository.save(red);
      typeRepository.save(mencia);
      typeRepository.save(syrah);

      wineryRepository.save(losada);
      wineryRepository.save(enrique_mendoza);
      wineryRepository.save(albala);

      wineshopRepository.save(wine1);
      wineshopRepository.save(wine2);
      wineshopRepository.save(wine3);

      regionRepository.findAll().forEach(r -> log.info("Preloaded: " + r));

      typeRepository.findAll().forEach(t -> log.info("Preloaded: " + t));

      wineryRepository.findAll().forEach(winery -> log.info("Preloaded: " + winery));

      wineshopRepository.findAll().forEach(w -> log.info("Preloaded " + w));
    };
  }
}

