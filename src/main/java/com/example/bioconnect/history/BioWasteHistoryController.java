package com.example.bioconnect.history;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
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


    @ApiOperation(value = "Deleting bioWasteHistory")
    @DeleteMapping("biowasteHistory/id")
    public ResponseEntity<?> deleteBioWaste(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Updating bioWasteHistory")
    @PutMapping("bioWasteHistory/id")
    public ResponseEntity<?> updateBioWasteHistory(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }
}
