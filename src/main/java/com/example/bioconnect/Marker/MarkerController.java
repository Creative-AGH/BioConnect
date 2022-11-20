package com.example.bioconnect.Marker;

import com.example.bioconnect.Marker.dto.MarkerOutputDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkerController {
    //pobranie wszystkich pinesek ( i jednej z detailsami )
    //dodanie , usunięcie
    @GetMapping("/marker/all")
    private List<MarkerOutputDto> getAllMarkers(){
        return null;
    }

    @GetMapping("/marker/{id}")
    private MarkerOutputDto getMarker(@RequestParam Long id){
        return null;

    }
    @PostMapping("/marker/add")
    private void MarkerInputDto(){

    }

}
