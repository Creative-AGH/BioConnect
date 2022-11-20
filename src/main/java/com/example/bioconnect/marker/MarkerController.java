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
    //pobranie wszystkich pinesek ( i jednej z detailsami )
    //dodanie , usunięcie
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
    private List<MarkerOutputDto> getAllMarkers() {
        return null;
    }

    @GetMapping("/marker/{id}")
    private MarkerOutputDto getMarker(@RequestParam Long id) {
        return null;
    }


}
