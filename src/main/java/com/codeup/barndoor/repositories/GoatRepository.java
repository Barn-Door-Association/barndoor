package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.Goat;
import com.codeup.barndoor.models.Herd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoatRepository extends JpaRepository<Goat, Long> {
    Goat findById(long id);
    List<Goat> findAllByHerdId(long herd_id);
}
