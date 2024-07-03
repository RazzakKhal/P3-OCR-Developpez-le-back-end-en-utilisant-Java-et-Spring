package com.projet3ocr.api.responses;

public enum KeysResponsesEnum implements EnumKey {
    TOKEN_KEY("token"),
    MESSAGE_KEY("message"),
    RENTALS_KEY("rentals");


    private final String value;
    private KeysResponsesEnum(String value){
        this.value = value;
    }
    @Override
    public String getKey(){
        return this.value;
    }
}

