package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.VaccineRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRecordsRepository extends JpaRepository<VaccineRecords, Long> {
    VaccineRecords findByGoatId(long id);
    VaccineRecords findById(long id);
}
