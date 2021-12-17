package com.rbt.csvparsermicroservice.domain.repositories;

import com.rbt.csvparsermicroservice.domain.models.VacationDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVacationDateRepository extends CrudRepository<VacationDate, Long> {
}
