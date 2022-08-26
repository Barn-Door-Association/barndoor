package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.GenericVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericVaccineRepository extends JpaRepository<GenericVaccine, Long> {
}
