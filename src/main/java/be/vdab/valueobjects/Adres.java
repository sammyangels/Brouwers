package be.vdab.valueobjects;

import be.vdab.constraints.Postcode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    @SafeHtml
    private String straat;
    @NotBlank
    @SafeHtml
    private String huisNr;
    @NotNull
    @Postcode
    private Integer postcode;
    @NotBlank
    @SafeHtml
    private String gemeente;

    public Adres() {
    }

    public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }
}
