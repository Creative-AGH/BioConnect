package com.example.bioconnect.farmer;

import com.example.bioconnect.coposter.ComposterService;
import com.example.bioconnect.farmer.dto.FarmerFertilizerUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FarmerController {
    private final FarmerService farmerService;
    private final ComposterService composterService;
    @GetMapping("/composters/{id}")
    public void getFertilizerFromComposer(@RequestParam String id)
    {

    }
    @GetMapping("/composters/oddFertlizer/{id}")
    public void removeFertilizerFromComposer(@RequestBody FarmerFertilizerUpdate dto)
    {


    }


}
