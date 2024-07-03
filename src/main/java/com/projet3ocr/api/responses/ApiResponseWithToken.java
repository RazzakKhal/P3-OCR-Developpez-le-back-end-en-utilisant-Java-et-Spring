package com.projet3ocr.api.responses;

import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor
public class ApiResponseWithToken<T extends EnumKey> {

    private T key;
    private String value;
    public Map<String, String> getResponse(){
        return Map.of(key.getKey(), value);
    }
}
