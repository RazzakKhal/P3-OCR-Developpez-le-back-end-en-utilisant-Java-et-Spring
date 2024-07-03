package com.projet3ocr.api.responses;

public enum RentalResponsesEnum implements EnumResponse{

    NOT_FOUNDED_RENTAL("Rental not found !"),
    CREATED_RENTAL("Rental created !"),
    SIMILAR_RENTAL_EXISTING("A similar Rental already exist !"),
    UPDATED_RENTAL("Rental updated !"),

    IMAGE_PROBLEM("A problem occurred during image processing");

    private final String value;
    RentalResponsesEnum(String value){
        this.value = value;
    }
    @Override
    public String getValue(){
        return this.value;
    }
}
