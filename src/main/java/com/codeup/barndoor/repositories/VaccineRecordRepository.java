package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRecordRepository extends JpaRepository<VaccineRecord, Long> {
    VaccineRecord findById (long id);
    List<VaccineRecord> findAllByGoatId (long id);
    List<VaccineRecord> findAllById (long id);
}
