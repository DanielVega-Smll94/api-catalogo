package com.marketkyke.catalogo.service;

import com.marketkyke.catalogo.dto.CountryDTO;
import com.marketkyke.catalogo.enums.APIError;
import com.marketkyke.catalogo.exception.ResourceNotException;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    public CountryDTO get(Long id){
        if(id != 1){
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }
        return new CountryDTO(1L ,"asd","asd");
    }
    public CountryDTO save(CountryDTO country){
        return country;
    }
    public CountryDTO update(Long id, CountryDTO country){
        return country;
    }
    public void delete(Long id){
        //TODO AGREGAR LOGICA
    }
}
