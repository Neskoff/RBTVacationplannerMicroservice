package rbt.excelimportv2.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import rbt.excelimportv2.entity.VacationDate;
import rbt.excelimportv2.entity.VacationYear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {

    public static List<VacationDate> parseVacationDateCSV(InputStream is) {
        List<VacationDate> vacationDates = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            List<CSVRecord> csvRecords = csvParser.getRecords();
            csvRecords.remove(0);
            for (CSVRecord csvRecord : csvRecords) {
                vacationDates.add(
                        new VacationDate(csvRecord.get(0),
                                new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.ENGLISH).parse(csvRecord.get(1)),
                                new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.ENGLISH).parse(csvRecord.get(2))
                        ));
            }
        } catch (IOException | ParseException exception) {
            System.out.println("Error parsing the CSV file, Exception details:\n" + exception.getMessage());
            return null;
        }
        return vacationDates;
    }

    public static List<VacationYear> parseVacationYearCSV(InputStream is) {
        List<VacationYear> employeesVacationYear = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            List<CSVRecord> csvRecords = csvParser.getRecords();
            int vacationYear = Integer.parseInt(csvRecords.get(0).get(1));
            csvRecords.remove(0);
            csvRecords.remove(0);
            for (CSVRecord csvRecord : csvRecords) {
                employeesVacationYear.add(
                        new VacationYear(csvRecord.get(0), vacationYear, "User", "User",
                                Integer.parseInt(csvRecord.get(1))));
            }
        } catch (Exception exception) {
            System.out.println("Error parsing the CSV file, Exception details:\n" + exception.getMessage());
            return null;
        }
        return employeesVacationYear;
    }
}
