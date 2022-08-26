package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    Vaccine findById (long id);
    Vaccine findAllById (long id);
}
