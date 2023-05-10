package org.datasource.json.locations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@JsonIgnoreProperties("_id")
public class CategorieView implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idCategorie;
    private String denumire;

    private Long greutateMin;
    private Long greutateMax;

    private Long valoareMin;
    private Long valoareMax;

    // @JsonIgnore
    private List<ColetView> colete = new ArrayList<>();

    public void addColet(ColetView colet){
        if (!colete.contains(colet)){
            colete.add(colet);
            colet.setCategorie(this);
        }
    }

    @XmlElementWrapper(name="colete") @XmlElement(name="colet")
    public List<ColetView> getColete() {
        return colete;
    }
    public void setCities(List<ColetView> colete) {
        // this.cities = cities;
        for(ColetView colet: colete)
            this.addColet(colet);
    }


    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Long getGreutateMin() {
        return greutateMin;
    }

    public void setGreutateMin(Long greutateMin) {
        this.greutateMin = greutateMin;
    }

    public Long getGreutateMax() {
        return greutateMax;
    }

    public void setGreutateMax(Long greutateMax) {
        this.greutateMax = greutateMax;
    }

    public Long getValoareMin() {
        return valoareMin;
    }

    public void setValoareMin(Long valoareMin) {
        this.valoareMin = valoareMin;
    }

    public Long getValoareMax() {
        return valoareMax;
    }

    public void setValoareMax(Long valoareMax) {
        this.valoareMax = valoareMax;
    }

    public CategorieView(Long idCategorie, String denumire, Long greutateMin, Long greutateMax, Long valoareMin, Long valoareMax) {
        this.idCategorie = idCategorie;
        this.denumire = denumire;
        this.greutateMin = greutateMin;
        this.greutateMax = greutateMax;
        this.valoareMin = valoareMin;
        this.valoareMax = valoareMax;
    }

    public CategorieView() {
        super();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCategorie == null) ? 0 : idCategorie.hashCode());
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
        CategorieView other = (CategorieView) obj;
        if (idCategorie == null) {
            if (other.idCategorie != null)
                return false;
        } else if (!idCategorie .equals(other.idCategorie))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CategorieView{" +
                "idCategorie=" + idCategorie +
                ", denumire='" + denumire + '\'' +
                ", greutateMin=" + greutateMin +
                ", greutateMax=" + greutateMax +
                ", valoareMin=" + valoareMin +
                ", valoareMax=" + valoareMax +
                ", colete=" + colete +
                '}';
    }
}
