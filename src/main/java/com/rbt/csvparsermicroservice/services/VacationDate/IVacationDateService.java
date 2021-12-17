package com.rbt.csvparsermicroservice.services.VacationDate;

import com.rbt.csvparsermicroservice.domain.models.VacationDate;

import java.util.List;

public interface IVacationDateService {
    boolean insertVacationDates(List<VacationDate> vacationDateList);

}
