package com.marketkyke.catalogo.exception;

import com.marketkyke.catalogo.enums.APIError;

public class ResourceNotException extends MarketKykeException{

    public ResourceNotException(APIError error) {
        super(error.getHttpStatus(), error.getMessage(), null);
    }
}
