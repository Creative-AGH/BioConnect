package com.example.bioconnect.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExcelService {

    private final GenerateExcelForSingleAccountService generateExcelForSingleAccountService;
    private final GenerateExcelRaportForAllUserWaste allAvailableItemsService;

    public String reportWithHIstoryForSingleAccount(String itemId) throws IOException {
        return encodeFileToBase64File(generateExcelForSingleAccountService.excelReportAboutSingleItem(itemId));
    }

    public String reportWithAllItems() throws IOException {
        return encodeFileToBase64File(allAvailableItemsService.excelReportForOneMonth(LocalDate.now()));
    }

    private String encodeFileToBase64File(File file) {
        try {
            return new String(Base64.encode(Files.readAllBytes(file.toPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
