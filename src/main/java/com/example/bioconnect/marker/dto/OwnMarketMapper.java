package com.example.bioconnect.marker.dto;

import com.example.bioconnect.AccountRepository;
import com.example.bioconnect.entities.Account;
import com.example.bioconnect.entities.Marker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnMarketMapper {
    private final AccountRepository accountRepository;

    //    @Mapping(source = "accountId", target = "account")
    public Marker mapMarkerInputDtoToMarker(MarkerInputDto markerInputDto) {
        Marker marker = new Marker();
        marker.setDescription(markerInputDto.getDescription());
        marker.setCategoryOfWaste(markerInputDto.getCategoryOfWaste());
        marker.setHowMuchBioWaste(markerInputDto.getHowMuchBioWaste());
        marker.setX(markerInputDto.getX());
        marker.setY(markerInputDto.getY());
        marker.setDateOfCreate(LocalDate.now());

        Optional<Account> optionalAccount = accountRepository.findById(markerInputDto.getAccountId());
        if (optionalAccount.isEmpty()) {
            throw new RuntimeException("Account with such id: " + markerInputDto.getAccountId() + " does not exist");
        }
        marker.setAccount(optionalAccount.get());
        return marker;
    }
}
