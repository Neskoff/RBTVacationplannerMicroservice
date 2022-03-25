package rbt.excelimportv2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VACATION_DATES")
@IdClass(VacationDateCompositeKey.class)
public class VacationDate {

    @Id
    @Column(name = "EMPLOYEE_EMAIL")
    private String employeeEmail;

    @Id
    @Column(name = "VACATION_START_DATE")
    private Date vacationStartDate;

    @Column(name = "VACATION_END_DATE", nullable = false)
    private Date vacationEndDate;
}
