package com.marketkyke.catalogo.service;

import com.marketkyke.catalogo.domain.Country;
import com.marketkyke.catalogo.dto.CountryDTO;
import com.marketkyke.catalogo.enums.APIError;
import com.marketkyke.catalogo.exception.DuplicateResourceException;
import com.marketkyke.catalogo.exception.ResourceNotException;
import com.marketkyke.catalogo.repository.CountryRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private CountryRepository countryRepository;
    private MapperFacade mapperFacade;

    @Autowired
    public CountryService(CountryRepository countryRepository, MapperFacade mapperFacade) {
        this.countryRepository = countryRepository;
        this.mapperFacade = mapperFacade;
    }
    public CountryDTO get(Long id) {

        Optional<Country> country = countryRepository.findById(id);

        if(country.isEmpty()) {
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }

        return mapperFacade.map(country.get(), CountryDTO.class);
    }
    public CountryDTO save(CountryDTO country) {
        Optional<Country> existCountry = countryRepository.findByCode(country.getCode());

        if(existCountry.isPresent()) {
            throw new DuplicateResourceException(APIError.COUNTRY_WITH_SAME_CODE);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(country, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public CountryDTO update(Long id, CountryDTO country) {
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(country, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public void delete(Long id) {
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            throw new ResourceNotException(APIError.COUNTRY_NOT_FOUND);
        }
        countryRepository.deleteById(id);
    }
}
