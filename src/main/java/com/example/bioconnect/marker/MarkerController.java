package com.example.bioconnect.marker;

import com.example.bioconnect.marker.dto.MarkerInputDto;
import com.example.bioconnect.marker.dto.MarkerOutputDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarkerController {
    private final MarkerService markerService;

    @ApiOperation(value = "Adding new marker")
    @PostMapping("/marker/add")
    private ResponseEntity<MarkerOutputDto> addMarker(@RequestBody MarkerInputDto markerInputDto) {
        MarkerOutputDto savedMarkerDto = markerService.addMarker(markerInputDto);
        URI savedItemUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMarkerDto.getId())
                .toUri();
        return ResponseEntity.created(savedItemUri).body(savedMarkerDto);
    }

    @GetMapping("/marker/all")
    private ResponseEntity<List<MarkerOutputDto>> getAllMarkers() {
        List<MarkerOutputDto> markerOutputDtoList = markerService.getAllMarkers();
        return ResponseEntity.ok(markerOutputDtoList);
    }

    @GetMapping("/marker/{id}")
    private ResponseEntity<MarkerOutputDto> getMarkerById(@RequestParam Long id) {
        MarkerOutputDto markerOutputDto = markerService.getMarkerById(id);
        return ResponseEntity.ok(markerOutputDto);
    }

    @ApiOperation(value = "Deleting marker")
    @DeleteMapping("marker/id")
    public ResponseEntity<?> deleteBioWaste(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Updating marker")
    @PutMapping("marker/id")
    public ResponseEntity<?> updateMarker(@RequestParam Long id){
        return ResponseEntity.noContent().build();
    }


}
