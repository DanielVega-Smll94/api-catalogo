package com.marketkyke.catalogo.controller;

import com.marketkyke.catalogo.dto.CountryDTO;
import com.marketkyke.catalogo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService service;

    @Autowired
    public CountryController(CountryService service ){
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> get(@PathVariable Long id){
        CountryDTO response = service.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //VALIDATED VALIDA TODO ESTE VALIDADO
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody @Validated CountryDTO country){
        CountryDTO response = service.save(country);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody @Validated CountryDTO country){
        CountryDTO response = service.update(id,country);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
