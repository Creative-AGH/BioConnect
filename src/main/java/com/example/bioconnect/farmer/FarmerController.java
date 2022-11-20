package com.example.bioconnect.farmer;

import com.example.bioconnect.coposter.ComposterService;
import com.example.bioconnect.farmer.dto.FarmerFertilizerUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
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
