package rbt.excelimportv2.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse {

    private LocalDateTime timeStamp;

    private String statusMessage;

}
