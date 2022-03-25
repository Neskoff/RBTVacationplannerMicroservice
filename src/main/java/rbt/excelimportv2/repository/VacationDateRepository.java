package rbt.excelimportv2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rbt.excelimportv2.entity.VacationDate;

@Repository
public interface VacationDateRepository extends CrudRepository<VacationDate, Long> {
}
