package com.example.bioconnect.api;


import com.example.bioconnect.bioWaste.FillBioWasteDto;
import com.example.bioconnect.bioWaste.GetBioWasteDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BioWasteController {
    private final BioWasteService bioWasteService;

    @ApiOperation(value = "Adding new bioWaste")
    @PostMapping("/addBioWaste")
    public ResponseEntity<GetBioWasteDto> addBioWaste(@RequestBody FillBioWasteDto fillBioWasteDto) {
        GetBioWasteDto savedBioWaste = bioWasteService.addBioWaste(fillBioWasteDto);
        URI savedItemUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBioWaste.getId())
                .toUri();
        return ResponseEntity.created(savedItemUri).body(savedBioWaste);
    }
}
