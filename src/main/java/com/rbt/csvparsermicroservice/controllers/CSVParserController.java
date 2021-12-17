package com.rbt.csvparsermicroservice.controllers;

import com.rbt.csvparsermicroservice.domain.repositories.IVacationDateRepository;
import com.rbt.csvparsermicroservice.services.VacationDate.IVacationDateService;
import com.rbt.csvparsermicroservice.utils.Utils;
import com.rbt.csvparsermicroservice.domain.models.Employee;
import com.rbt.csvparsermicroservice.services.IEmployeeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class CSVParserController {
    @Resource
    private IEmployeeService iEmployeeService;
    @Resource
    private IVacationDateService vacationDateService;
    @GetMapping("/allemployes")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        if (!iEmployeeService.getAllEmployees().isEmpty()) {
            return ResponseEntity.ok(iEmployeeService.getAllEmployees());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/parsecsv")
    public ResponseEntity<Object> parseCSV(@RequestPart MultipartFile multipartFile) {
        if (!Objects.equals(FilenameUtils.getExtension(multipartFile.getOriginalFilename()), "csv"))
            return ResponseEntity.badRequest().body("Incompatible file type");
        try{
            return ResponseEntity.ok().body(vacationDateService.insertVacationDates(
                    Utils.parseVacationDateCSV(multipartFile.getInputStream())));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error processing the file");
        }
    }
}
