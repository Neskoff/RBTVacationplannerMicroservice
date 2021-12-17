package com.rbt.csvparsermicroservice.services.VacationDate;

import com.rbt.csvparsermicroservice.domain.models.VacationDate;
import com.rbt.csvparsermicroservice.domain.repositories.IVacationDateRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacationDateService implements IVacationDateService {
    @Resource
    private IVacationDateRepository vacationDateRepository;

    @Override
    public boolean insertVacationDates(List<VacationDate> vacationDateList) {
        try {
            vacationDateRepository.saveAll(vacationDateList);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
