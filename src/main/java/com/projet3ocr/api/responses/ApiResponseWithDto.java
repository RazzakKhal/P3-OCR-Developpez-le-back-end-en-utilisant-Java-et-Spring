package com.projet3ocr.api.responses;

import lombok.AllArgsConstructor;

import java.util.Map;
@AllArgsConstructor
public class ApiResponseWithDto<T extends EnumKey, U> {

    T keysEnum;
    U dtos;
    public Map<String, U> getResponse(){
        return Map.of(keysEnum.getKey(), dtos);
    }
}
