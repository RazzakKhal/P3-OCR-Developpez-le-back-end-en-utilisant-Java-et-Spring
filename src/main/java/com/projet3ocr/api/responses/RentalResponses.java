package com.projet3ocr.api.responses;

public enum RentalResponses {

    CREATED_RENTAL("Rental created !"),
    UPDATED_RENTAL("Rental updated !");

    private final String value;
    RentalResponses(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
