package rbt.excelimportv2.service.vacationdate;

import rbt.excelimportv2.entity.VacationDate;

import java.util.List;

public interface IVacationDateService {

    boolean insertVacationDates(List<VacationDate> vacationDateList);
}
