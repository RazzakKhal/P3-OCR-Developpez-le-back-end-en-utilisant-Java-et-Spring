package com.projet3ocr.api.responses;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ApiResponseWithString<T extends EnumKey, U extends EnumResponse> {
    private T key;

    private U enumResponse;
    public Map<String, String> getResponse(){
        return Map.of(key.getKey(), enumResponse.getValue());
    }
}
