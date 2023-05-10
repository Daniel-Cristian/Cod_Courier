package org.datasource.json.locations;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class ColetView implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long idColet;

    private Long greutate;

    private Long valoare;
    private String continut;

    @JsonIgnore
    private CategorieView categorie;

    @XmlTransient
    public CategorieView getCategorie() {
        return categorie;
    }
    public void setCategorie(CategorieView categorie) {
        this.categorie = categorie;
    }

    public Long getIdColet() {
        return idColet;
    }

    public void setIdColet(Long idColet) {
        this.idColet = idColet;
    }

    public Long getGreutate() {
        return greutate;
    }

    public void setGreutate(Long greutate) {
        this.greutate = greutate;
    }

    public Long getValoare() {
        return valoare;
    }

    public void setValoare(Long valoare) {
        this.valoare = valoare;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public ColetView(Long idColet, Long greutate, Long valoare, String continut, CategorieView categorie) {
        this.idColet = idColet;
        this.greutate = greutate;
        this.valoare = valoare;
        this.continut = continut;
        this.categorie = categorie;
    }

    public ColetView() {
        super();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idColet == null) ? 0 : idColet.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ColetView other = (ColetView ) obj;
        if (idColet == null) {
            if (other.idColet != null)
                return false;
        } else if (!idColet.equals(other.idColet))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ColetView{" +
                "idColet=" + idColet +
                ", greutate=" + greutate +
                ", valoare=" + valoare +
                ", continut='" + continut + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
