package com.example.bioconnect.farmer;

import com.example.bioconnect.farmer.dto.FarmerFertilizerUpdate;
import com.example.bioconnect.farmer.dto.FarmerPaidFertilizerUpdate;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class FarmerController {
    private final FarmerService farmerService;

    @ApiOperation("Getting part of composter from user")
    @PostMapping("/composters/getFertilizerFromComposer")
    public void getFertilizerFromComposer(@RequestBody FarmerFertilizerUpdate farmerFertilizerUpdate) {
        farmerService.getFertilizerFromComposer(farmerFertilizerUpdate);
    }

    @PostMapping("/composters/getPaidFertilizerFromComposer")
    public void getPaidFertilizerFromComposer(@RequestBody FarmerPaidFertilizerUpdate farmerPaidFertilizerUpdate) {
        farmerService.getPaidFertilizerFromComposer(farmerPaidFertilizerUpdate);
    }


}
