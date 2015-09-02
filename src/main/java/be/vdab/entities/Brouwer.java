package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Brouwer implements Serializable {
    private static final long serialVersionUID = 1L;
    private long brouwerNr;
    @NotBlank
    private String naam;
    @NotNull
    @Valid
    private Adres adres;
    @Min(0)
    private Integer omzet;

    public Brouwer() {
    }

    public Brouwer(String naam, Adres adres, Integer omzet) {
        this.adres = adres;
        this.naam = naam;
        this.omzet = omzet;
    }

    public Brouwer(long brouwerNr,String naam, Adres adres, Integer omzet) {
        this(naam, adres, omzet);
        this.brouwerNr = brouwerNr;
    }

    public long getBrouwerNr() {
        return brouwerNr;
    }

    public void setBrouwerNr(long brouwerNr) {
        this.brouwerNr = brouwerNr;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getOmzet() {
        return omzet;
    }

    public void setOmzet(Integer omzet) {
        this.omzet = omzet;
    }
}
