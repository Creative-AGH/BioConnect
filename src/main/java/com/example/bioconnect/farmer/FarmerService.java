package com.example.bioconnect.farmer;

import com.example.bioconnect.AccountRepository;
import com.example.bioconnect.entities.Account;
import com.example.bioconnect.entities.Composter;
import com.example.bioconnect.farmer.dto.FarmerFertilizerUpdate;
import com.example.bioconnect.farmer.dto.FarmerPaidFertilizerUpdate;
import com.example.bioconnect.repositories.ComposterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FarmerService {
    private final ComposterRepository composterRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public void getFertilizerFromComposer(FarmerFertilizerUpdate farmerFertilizerUpdate) {
        Long composterId = farmerFertilizerUpdate.getComposterIdFromWhichYouCanGet();
        Optional<Composter> optionalComposter = composterRepository.findById(composterId);
        if (optionalComposter.isPresent()) {
            Composter composter = optionalComposter.get();
            double wasteLitersToGet = farmerFertilizerUpdate.getWasteLitersToGet();
            if (composter.getActualCapacity() - wasteLitersToGet < 0) {
                throw new RuntimeException("There is no enough liters of composter to get, just only: "
                        + composter.getActualCapacity());
            }
            composter.setActualCapacity(composter.getActualCapacity() - wasteLitersToGet);
            composterRepository.save(composter);
        } else {
            throw new RuntimeException("There is no such composter id");
        }
    }

    @Transactional
    public void getPaidFertilizerFromComposer(FarmerPaidFertilizerUpdate farmerPaidFertilizerUpdate) {
        Long composterId = farmerPaidFertilizerUpdate.getComposterIdFromWhichYouCanGet();
        Optional<Composter> optionalComposter = composterRepository.findById(composterId);
        Optional<Account> optionalBuyerAccount = accountRepository.findById(farmerPaidFertilizerUpdate.getBuyerAccountId());
        Optional<Account> optionalSellerAccount = accountRepository.findById(farmerPaidFertilizerUpdate.getSellerAccountId());
        if (optionalBuyerAccount.isEmpty() || optionalSellerAccount.isEmpty()) {
            throw new RuntimeException("There is no such accounts id (buyer or seller)");
        }
        if (optionalComposter.isPresent()) {
            Composter composter = optionalComposter.get();
            double wasteLitersToGet = farmerPaidFertilizerUpdate.getWasteLitersToGet();
            if (composter.getActualCapacity() - wasteLitersToGet < 0) {
                throw new RuntimeException("There is no enough liters of composter to get, just only: "
                        + composter.getActualCapacity());
            }
            Account buyer = optionalBuyerAccount.get();
            Account seller = optionalSellerAccount.get();
            if (buyer.getAvailableCash() - farmerPaidFertilizerUpdate.getForHowManyCashYouCanBuy() < 0) {
                throw new RuntimeException("Buyer has not enough available cash to buy this composter");
            }
            buyer.setAvailableCash(buyer.getAvailableCash() - farmerPaidFertilizerUpdate.getForHowManyCashYouCanBuy());
            accountRepository.save(buyer);
            seller.setAvailableCash(seller.getAvailableCash() + farmerPaidFertilizerUpdate.getForHowManyCashYouCanBuy());
            accountRepository.save(seller);
            composter.setActualCapacity(composter.getActualCapacity() - wasteLitersToGet);
            composterRepository.save(composter);
        } else {
            throw new RuntimeException("There is no such composter id");
        }
    }
}
