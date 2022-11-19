package com.example.bioconnect.history;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BioWasteHistoryController {
    private final BioWasteHistoryService bioWasteHistoryService;

    @ApiOperation(value = "getting sum of bio waste in specified time")
    @GetMapping("/biowasteHistory/getSumOfBioWasteInSpecifiedTime/{fromDate}/{toDate}")
    public double getSumOfBioWasteInSpecifiedTime(@RequestParam String fromDate, @RequestParam String toDate) {
        return bioWasteHistoryService.getSumOfBioWasteInSpecifiedTime(fromDate, toDate);
    }


    @GetMapping("/biowasteHistory/getHistoryOfBioWasteForAccountId/{accountId}")
    public List<GetBioWasteHistoryDto> getHistoryOfBioWasteForAccountId(@RequestParam String accountId) {
        return bioWasteHistoryService.getHistoryOfBioWasteForAccountId(accountId);
    }
}
