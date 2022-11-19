package com.example.bioconnect.bioWaste;


import com.example.bioconnect.bioWaste.dto.FillBioWasteDto;
import com.example.bioconnect.bioWaste.dto.GetBioWasteDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class BioWasteController {
    private final BioWasteService bioWasteService;

    @ApiOperation(value = "Adding new bioWaste")
    @PostMapping("/biowaste/add")
    public ResponseEntity<GetBioWasteDto> addBioWaste(@RequestBody @Valid FillBioWasteDto fillBioWasteDto) {
        GetBioWasteDto savedBioWaste = bioWasteService.addBioWaste(fillBioWasteDto);
        URI savedItemUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBioWaste.getId())
                .toUri();
        return ResponseEntity.created(savedItemUri).body(savedBioWaste);
    }


}