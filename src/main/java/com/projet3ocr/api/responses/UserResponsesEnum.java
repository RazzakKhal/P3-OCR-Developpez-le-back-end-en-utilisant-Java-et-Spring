package com.projet3ocr.api.responses;

public enum UserResponsesEnum implements EnumResponse{
    NOT_FOUNDED_USER("Utilisateur non trouvé");

    private final String value;
    private UserResponsesEnum(String value){
        this.value = value;
    }
    @Override
   public String getValue(){
        return this.value;
    }
}
