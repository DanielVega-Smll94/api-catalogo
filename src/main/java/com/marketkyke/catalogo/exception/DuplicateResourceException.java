package com.marketkyke.catalogo.exception;


import com.marketkyke.catalogo.enums.APIError;

public class DuplicateResourceException extends MarketKykeException {

    public DuplicateResourceException(APIError error) {
        super(error.getHttpStatus(), error.getMessage(), null);
    }
}