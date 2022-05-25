package com.example.wine;

import com.example.wine.Classes.Winery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineryRepository extends JpaRepository<Winery, Long> {
}
