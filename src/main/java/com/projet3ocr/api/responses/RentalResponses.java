package com.projet3ocr.api.responses;

public enum RentalResponses {

    NOT_FOUNDED_RENTAL("Rental not found !"),
    CREATED_RENTAL("Rental created !"),
    SIMILAR_RENTAL_EXISTING("A similar Rental already exist !"),
    UPDATED_RENTAL("Rental updated !");

    private final String value;
    RentalResponses(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
