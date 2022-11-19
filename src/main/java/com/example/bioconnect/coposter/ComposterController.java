package com.example.bioconnect.coposter;

import com.example.bioconnect.bioWaste.FillBioWasteDto;
import com.example.bioconnect.bioWaste.GetBioWasteDto;
import com.example.bioconnect.coposter.dto.FillComposterDto;
import com.example.bioconnect.coposter.dto.GetComposterDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ComposterController {

    private final ComposterService composterService;
    @ApiOperation(value = "Adding new bioWaste")
    @PostMapping("/addBioWaste")
    public ResponseEntity<GetComposterDto> addComposter(@RequestBody FillComposterDto fillComposterDto) {
        GetComposterDto savedComposterDto = composterService.addBioWaste(fillComposterDto);
        URI savedItemUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedComposterDto.getId())
                .toUri();
        return ResponseEntity.created(savedItemUri).body(savedComposterDto);
    }
}