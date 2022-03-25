package rbt.excelimportv2.service.vacationdate;

import org.springframework.stereotype.Service;
import rbt.excelimportv2.entity.VacationDate;
import rbt.excelimportv2.repository.VacationDateRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacationDateService implements IVacationDateService {

    @Resource
    private VacationDateRepository vacationDateRepository;

    @Override
    public boolean insertVacationDates(List<VacationDate> vacationDateList) {
        if (vacationDateList == null)
            return false;
        vacationDateRepository.saveAll(vacationDateList);
        return true;
    }
}
