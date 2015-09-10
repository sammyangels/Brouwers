package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "brouwers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Brouwer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String naam;
    @NotNull
    @Valid
    @Embedded
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

    public Brouwer(long id,String naam, Adres adres, Integer omzet) {
        this(naam, adres, omzet);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
