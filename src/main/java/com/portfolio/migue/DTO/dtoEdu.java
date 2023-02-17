package com.portfolio.migue.DTO;

import javax.validation.constraints.NotBlank;

public class dtoEdu {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public dtoEdu() {
    }

    public dtoEdu(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }


}
