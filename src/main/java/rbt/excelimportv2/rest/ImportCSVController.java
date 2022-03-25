package rbt.excelimportv2.rest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rbt.excelimportv2.models.ApiResponse;
import rbt.excelimportv2.service.vacationdate.IVacationDateService;
import rbt.excelimportv2.service.vacationyear.IVacationYearService;
import rbt.excelimportv2.utils.Utils;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1/excel-import")
public class ImportCSVController {

    @Resource
    private IVacationDateService vacationDateService;

    @Resource
    private IVacationYearService vacationYearService;

    @PostMapping(value = "/vacation-dates",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ApiResponse> parseVacationDateCSV(@RequestPart MultipartFile multipartFile) throws IOException {
        if (checkFileExtension(multipartFile))
            return ResponseEntity.badRequest().body(new ApiResponse(LocalDateTime.now(), "Incompatible file type"));
        if (vacationDateService.insertVacationDates(Utils.parseVacationDateCSV(multipartFile.getInputStream()))) {
            return ResponseEntity.accepted().body(new ApiResponse(LocalDateTime.now(), "Successful insert"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse(LocalDateTime.now(), "Error processing file"));
    }

    @PostMapping(value = "/vacation-year",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ApiResponse> parseEmployeeDataCSV(@RequestPart MultipartFile multipartFile) throws IOException {
        if (checkFileExtension(multipartFile))
            return ResponseEntity.badRequest().body(new ApiResponse(LocalDateTime.now(), "Incompatible file type"));
        if (vacationYearService.insertVacationYear(Utils.parseVacationYearCSV(multipartFile.getInputStream()))) {
            return ResponseEntity.accepted().body(new ApiResponse(LocalDateTime.now(), "Successful insert"));
        } else
            return ResponseEntity.badRequest().body(new ApiResponse(LocalDateTime.now(), "Error processing file"));
    }

    private boolean checkFileExtension(MultipartFile multipartFile) {
        return !Objects.equals(FilenameUtils.getExtension(multipartFile.getOriginalFilename()), "csv");
    }
}
