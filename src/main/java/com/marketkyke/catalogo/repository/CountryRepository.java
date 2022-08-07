package com.marketkyke.catalogo.repository;

import com.marketkyke.catalogo.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country,Long> {

    Optional<Country>findByCode(String code);

}
