package rbt.excelimportv2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VACATION_YEAR")
@IdClass(VacationYearCompositeKey.class)
public class VacationYear {

    @Id
    @Column(name = "EMAIL")
    private String employeeEmail;

    @Id
    @Column(name = "YEAR")
    private int vacationYear;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "VACATION_DAYS")
    private int totalVacationDays;


}
