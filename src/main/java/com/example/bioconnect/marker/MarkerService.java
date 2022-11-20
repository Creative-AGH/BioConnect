package com.example.bioconnect.marker;

import com.example.bioconnect.entities.Marker;
import com.example.bioconnect.marker.dto.MarkerInputDto;
import com.example.bioconnect.marker.dto.MarkerMapper;
import com.example.bioconnect.marker.dto.MarkerOutputDto;
import com.example.bioconnect.marker.dto.OwnMarketMapper;
import com.example.bioconnect.repositories.MarkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarkerService {
    private final MarkerMapper markerMapper;
    private final MarkerRepository markerRepository;
    private final OwnMarketMapper ownMarketMapper;
    @Transactional
    public MarkerOutputDto addMarker(MarkerInputDto markerInputDto) {
        Marker markerToSave = ownMarketMapper.mapMarkerInputDtoToMarker(markerInputDto);
        Marker savedMarker = markerRepository.save(markerToSave);
        log.info("Successfully created and saved marker");
        return markerMapper.mapMarkerToMarkerOutputDto(savedMarker);
    }

    public MarkerOutputDto getMarkerById(Long id) {
        Optional<Marker> optionalMarker = markerRepository.findById(id);
        if(optionalMarker.isEmpty()){
            throw new RuntimeException("Marker with id: " + id + "does not exist");
        }
        return markerMapper.mapMarkerToMarkerOutputDto(optionalMarker.get());
    }

    public List<MarkerOutputDto> getAllMarkers() {
        List<MarkerOutputDto> markerOutputDtoList = new ArrayList<>();
        for (Marker marker : markerRepository.findAll()) {
            markerOutputDtoList.add(markerMapper.mapMarkerToMarkerOutputDto(marker));
        }
        return markerOutputDtoList;
    }
}
