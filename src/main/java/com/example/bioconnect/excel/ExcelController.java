package com.example.bioconnect.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ExcelController {
    private final ExcelService excelService;

    @PostMapping("/excel/account/{email}")
    public String encodedBase64ExcelReport(@PathVariable String email) throws IOException {
        return excelService.reportWithHIstoryForSingleAccount(email);

    }

    @PostMapping("/excel/wastePerUser")
    public String generateReport() throws IOException {
        return excelService.reportWithAllItems();
    }
}
