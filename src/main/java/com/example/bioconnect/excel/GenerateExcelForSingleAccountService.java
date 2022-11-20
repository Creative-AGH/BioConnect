package com.example.bioconnect.excel;

import com.example.bioconnect.AccountRepository;
import com.example.bioconnect.entities.Account;
import com.example.bioconnect.entities.BioWasteHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateExcelForSingleAccountService {
    private static String dataToExcel(BioWasteHistory history)
    {
        return new StringBuilder()
                .append(history.getTimeOfEvent())
                .append(";")
                .append(history.getBioWasteId())
                .append(";")
                .append(history.getHowMuchBioWaste())
                .append(";")
                .append(history.getTypeOfEvent())
                .append(";")
                .append(history.getCommentToEvent()).toString();

    }
    private final AccountRepository accountRepository;
    private final ExcelUtilities excelUtilities;
    //time of event, biowasteID , howMutchBiowaste,TypeOfEvent,Comment to event
    //TITLE WORKSHEETA account ID
    private static final String[] headerRows = {"Czas wydarzenia", "Id wyrzuconych rzeczy", "Ile zostało wyrzucone",
            "Typ wydarzenia", "Komentarz do wydarzenia"};


    public File excelReportAboutSingleItem(String itemId) throws IOException {
        Optional<Account> AccountOptional = accountRepository.findById(itemId);
        if (AccountOptional.isEmpty()) {
            throw new RuntimeException("NOT FOUND ACCOUNT");
        } else {
            Account account = AccountOptional.get();
            List<BioWasteHistory> history = account.getHistory();

            List<String> detailsBeforeEvent = history
                    .stream()
                    .map(GenerateExcelForSingleAccountService::dataToExcel)
                    .toList();
            List<String[]> rows = detailsBeforeEvent
                    .stream()
                    .map(s -> s.split(";"))
                    .toList();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(account.getEmail());
            excelUtilities.setupCellStylesForCurrentWorkbook(workbook);
            excelUtilities.prepareHeader(sheet, headerRows, ExcelUtilities.YELLOW, ExcelUtilities.ORANGE, ExcelUtilities.GREEN);
            int rowIndex = 1;
            for (BioWasteHistory bioWasteHistory : history) {

                Row row = sheet.createRow(rowIndex);
                Cell cell = row.createCell(0);
                cell.setCellValue(rowIndex);
                cell.setCellStyle(ExcelUtilities.YELLOW_DATE);

                excelUtilities.buildMainData(row, 3, rows.get(rowIndex - 1), ExcelUtilities.ORANGE, ExcelUtilities.GREEN,ExcelUtilities.YELLOW);
                rowIndex++;
            }
            excelUtilities.autoSizeColumnsInRange(sheet, 1, headerRows.length);
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
            return new File(fileLocation);
        }
    }
}
