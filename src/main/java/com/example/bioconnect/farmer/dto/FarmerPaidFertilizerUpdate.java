package com.example.bioconnect.farmer.dto;

import lombok.Data;

@Data
public class FarmerPaidFertilizerUpdate {
    private String buyerAccountId;
    private String sellerAccountId;
    private Long composterIdFromWhichYouCanGet;
    private double wasteLitersToGet;
    private double forHowManyCashYouCanBuy;
}
