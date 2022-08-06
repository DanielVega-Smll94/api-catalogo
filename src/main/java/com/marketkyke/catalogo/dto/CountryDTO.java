package com.marketkyke.catalogo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CountryDTO {
    private Long id;

    @Size(min=2, max =3)
    private String code;
    //USE A VALIDATOR THAT IS INCLUDE IN POM.XML
    @NotEmpty(message = "This attribute is mandatory")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CountryDTO() {
    }

    public CountryDTO(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }
}
