package rbt.excelimportv2.service.vacationyear;

import org.springframework.stereotype.Service;
import rbt.excelimportv2.entity.VacationYear;
import rbt.excelimportv2.repository.IVacationYearRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacationYearService implements IVacationYearService {

    @Resource
    private IVacationYearRepository vacationYearRepository;

    @Override
    public boolean insertVacationYear(List<VacationYear> vacationYearList) {
        try {
            vacationYearRepository.saveAll(vacationYearList);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
