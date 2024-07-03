package com.projet3ocr.api.responses;

public enum MessageResponsesEnum implements EnumResponse{
    SENDED_MESSAGE("Message send with succes");

    private final String value;
    private MessageResponsesEnum(String value){
        this.value = value;
    }
    @Override
    public String getValue(){
    return this.value;
    }


}
