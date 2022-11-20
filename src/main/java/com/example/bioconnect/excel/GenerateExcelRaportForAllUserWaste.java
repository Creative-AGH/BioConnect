package com.example.bioconnect.excel;

import com.example.bioconnect.AccountRepository;
import com.example.bioconnect.entities.Account;
import com.example.bioconnect.entities.BioWasteHistory;
import com.example.bioconnect.history.BioWasteHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateExcelRaportForAllUserWaste {

    //    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final BioWasteHistoryService bioWasteHistoryService;
    private final ExcelUtilities excelUtilities;
    //1)email , ilość śmieci ...

    private static final String[] headerRows = {
            "Email", "Ilość bio odpadów wyprodukowana przez mieszkańca"};

    private static String dataToExcel(String email, Double totalWaste) {
        return new StringBuilder()
                .append(email)
                .append(";")
                .append(totalWaste).toString();
    }

    public File excelReportForOneMonth(LocalDate when) throws IOException {
//        when.getMonth().minus(1);

        List<String> emails = StreamSupport.stream(accountRepository.findAll().spliterator(), false).map(Account::getEmail)
                .collect(Collectors.toList());
        List<Double> detailsBeforeEvent = StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .map(account -> account
                        .getHistory()
                        .stream()
                        .filter(x -> when.minusMonths(1).isAfter(x.getTimeOfEvent().toLocalDate())
                                && when.isBefore(x.getTimeOfEvent().toLocalDate()))
                        .map(BioWasteHistory::getHowMuchBioWaste).collect(Collectors.toList()))
                .map(lista -> lista.stream().mapToDouble(Double::doubleValue).sum())
                .collect(Collectors.toList());
        int i = 0;
        List<String> records = new ArrayList<>();
        for (String email : emails) {
            records.add(dataToExcel(email, detailsBeforeEvent.get(i)));
            i++;
        }

//        StringBuilder builder = new StringBuilder();
//
//        String.valueOf(LocalDate.now().getYear());
//        String.valueOf(LocalDate.now().getMonthValue());
//
//        builder.append(LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue()+"-"+"01");
//        String detailsBefore=EventStreamSupport.stream(accountRepository.findAll().spliterator(),false)
//                .map(account -> dataToExcel(account.getEmail(),
//                        bioWasteHistoryService.getSumOfBioWasteInSpecifiedTime(LocalDate.now().minusMonths(1).getMonth().toString(),LocalDate.now().getMonth().toString())))

        List<String[]> rows = records
                .stream()
                .map(s -> s.split(";"))
                .toList();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Wszystkie dane z miesiąca");
        excelUtilities.setupCellStylesForCurrentWorkbook(workbook);
        excelUtilities.prepareHeader(sheet, headerRows, ExcelUtilities.YELLOW, ExcelUtilities.ORANGE, ExcelUtilities.GREEN);
        int rowIndex = 1;
        for (String bioWasteHistory : records) {

            Row row = sheet.createRow(rowIndex);

            excelUtilities.buildMainData(row, 0, rows.get(rowIndex - 1), ExcelUtilities.YELLOW, ExcelUtilities.ORANGE, ExcelUtilities.GREEN);
            rowIndex++;
        }
        excelUtilities.autoSizeColumnsInRange(sheet, 0, headerRows.length);
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "wszystkie_dane.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
        return new File(fileLocation);

    }
}