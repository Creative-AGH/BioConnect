package com.example.bioconnect.coposter;

import com.example.bioconnect.coposter.dto.FillComposterDto;
import com.example.bioconnect.coposter.dto.GetComposterDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ComposterController {

    private final ComposterService composterService;

    @ApiOperation(value = "Adding new composter")
    @PostMapping("/composter/add")
    public ResponseEntity<GetComposterDto> addComposter(@RequestBody @Valid FillComposterDto fillComposterDto) {
        GetComposterDto savedComposterDto = composterService.addComposter(fillComposterDto);
        URI savedItemUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedComposterDto.getId())
                .toUri();
        return ResponseEntity.created(savedItemUri).body(savedComposterDto);
    }

    @GetMapping("/composter/getItemByItemId/{composterId}")
    public ResponseEntity<GetComposterDto> getItemByItemId(@RequestParam Long composterId) {
        GetComposterDto getComposterDto = composterService.getComposterByComposterId(composterId);
        return ResponseEntity.ok(getComposterDto);
    }

    @GetMapping("/composter/getAllComposters")
    public ResponseEntity<List<GetComposterDto>> getAllComposters() {
        List<GetComposterDto> getCompostersDto = composterService.getAllComposters();
        return ResponseEntity.ok(getCompostersDto);
    }

    @ApiOperation(value = "Deleting composter")
    @DeleteMapping("composter/id")
    public ResponseEntity<?> deleteComposter(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Updating composter")
    @PutMapping("composter/id")
    public ResponseEntity<?> updateComposter(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }
}
