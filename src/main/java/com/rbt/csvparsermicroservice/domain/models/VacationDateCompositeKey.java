package com.rbt.csvparsermicroservice.domain.models;

import java.io.Serializable;
import java.util.Date;

public class VacationDateCompositeKey implements Serializable {
    private String employeeEmail;
    private Date vacationStartDate;
}
