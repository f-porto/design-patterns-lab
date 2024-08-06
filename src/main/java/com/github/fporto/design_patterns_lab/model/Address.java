package com.github.fporto.design_patterns_lab.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("zip")
    @JsonAlias({"cep"})
    private String zip;

    @JsonProperty("state")
    @JsonAlias({"uf"})
    private String state;

    @JsonProperty("locality")
    @JsonAlias({"localidade"})
    private String locality;

    @JsonProperty("unit")
    @JsonAlias({"unidade"})
    private String unit;

    @JsonProperty("neighborhood")
    @JsonAlias({"bairro"})
    private String neighborhood;

    @JsonProperty("street")
    @JsonAlias({"logradouro"})
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
