package rbt.excelimportv2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rbt.excelimportv2.entity.VacationYear;

@Repository
public interface IVacationYearRepository extends CrudRepository<VacationYear, Long> {
}
