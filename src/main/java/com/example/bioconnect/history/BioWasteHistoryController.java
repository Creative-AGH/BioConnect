package com.example.bioconnect.history;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
@RequiredArgsConstructor
public class BioWasteHistoryController {
    private final BioWasteHistoryService bioWasteHistoryService;

    @ApiOperation(value = "getting sum of bio waste in specified time")
    @GetMapping("/biowasteHistory/getSumOfBioWasteInSpecifiedTime/{fromDate}/{toDate}")
    public double getSumOfBioWasteInSpecifiedTime(@RequestParam String fromDate, @RequestParam String toDate) {
        return bioWasteHistoryService.getSumOfBioWasteInSpecifiedTime(fromDate, toDate);
    }
}
