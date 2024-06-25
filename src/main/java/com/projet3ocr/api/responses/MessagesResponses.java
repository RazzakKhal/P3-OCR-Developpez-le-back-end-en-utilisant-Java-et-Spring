package com.projet3ocr.api.responses;

public enum MessagesResponses {
    SENDED_MESSAGE("Message send with succes");

    private final String value;
    private MessagesResponses(String value){
        this.value = value;
    }
    public String getValue(){
    return this.value;
    }


}
