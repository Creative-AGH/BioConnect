package com.example.bioconnect.history;

import com.example.bioconnect.coposter.dto.GetComposterDto;
import com.example.bioconnect.entities.BioWasteHistory;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
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
