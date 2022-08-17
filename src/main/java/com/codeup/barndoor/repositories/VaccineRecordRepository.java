package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.VaccineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRecordRepository extends JpaRepository<VaccineRecord, Long> {
    Record findById (long id);
    List<Record> findAllByGoatId (long id);
    List<Record> findAllById (long id);
}
