package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.Herd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerdRepository extends JpaRepository<Herd, Long> {
    Herd findById(long id);
}