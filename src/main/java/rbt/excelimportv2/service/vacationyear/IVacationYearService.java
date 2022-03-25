package rbt.excelimportv2.service.vacationyear;

import rbt.excelimportv2.entity.VacationYear;

import java.util.List;

public interface IVacationYearService {

    boolean insertVacationYear(List<VacationYear> vacationYearList);
}
