package com.projet3ocr.api.responses;

public enum UsersResponses {
    NOT_FOUNDED_USER("Utilisateur non trouvé");

    private final String value;
    private UsersResponses(String value){
        this.value = value;
    }

   public String getValue(){
        return this.value;
    }
}
