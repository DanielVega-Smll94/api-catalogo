package com.marketkyke.catalogo.dto;
import javax.validation.constraints.*;

public class CountryDTO {
    private Long id;

    @Size(min=2, max =3)
    private String code;
    //USE A VALIDATOR THAT IS INCLUDE IN POM.XML
    @NotBlank(message = "Description is mandatory")
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
