package org.datasource.xlsx.categories;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement

public class DestinatariView {
    private String idDestinatar;
    private String nume;

    private String prenume;

    private String adresa;

    private String mediu;

    private String codPostal;

    private String nrTelefon;

    public String getIdDestinatar() {
        return idDestinatar;
    }

    public void setIdDestinatar(String idDestinatar) {
        this.idDestinatar = idDestinatar;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMediu() {
        return mediu;
    }

    public void setMediu(String mediu) {
        this.mediu = mediu;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public DestinatariView() {
        super();
    }

    public DestinatariView(String idDestinatar, String nume, String prenume, String adresa, String mediu, String codPostal, String nrTelefon) {
        this.idDestinatar = idDestinatar;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.mediu = mediu;
        this.codPostal = codPostal;
        this.nrTelefon = nrTelefon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDestinatar());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DestinatariView other = (DestinatariView) obj;
        if (idDestinatar == null) {
            if (other.idDestinatar != null)
                return false;
        } else if (!idDestinatar.equals(other.idDestinatar))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DestinatariView{" +
                "idDestinatar='" + idDestinatar + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", mediu='" + mediu + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", nrTelefon='" + nrTelefon + '\'' +
                '}';
    }
}
