package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.Herd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HerdRepository extends JpaRepository<Herd, Long> {
    Herd findById(long id);
    List<Herd> findByUserId(long id);
}