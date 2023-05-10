package org.datasource.xlsx.categories;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

@XmlRootElement
public class VehiculeView {
    private String idVehicul;
    private String marca;
    private String model;
    private String categorie;
    private String nrInmatriculare;
    private Date dataInmatriculare;
    private String anFabricatie;
    private Double km;
    private String tipMotor;
    private String Carburant;
    private Double Putere;
    private String ITP;
    private String Asigurare;

    private String transmisie;

    private String accident;

    private Double pretAchizitie;

    public String getIdVehicul() {
        return idVehicul;
    }

    public void setIdVehicul(String idVehicul) {
        this.idVehicul = idVehicul;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public Date getDataInmatriculare() {
        return dataInmatriculare;
    }

    public void setDataInmatriculare(Date dataInmatriculare) {
        this.dataInmatriculare = dataInmatriculare;
    }

    public String getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(String anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public String getTipMotor() {
        return tipMotor;
    }

    public void setTipMotor(String tipMotor) {
        this.tipMotor = tipMotor;
    }

    public String getCarburant() {
        return Carburant;
    }

    public void setCarburant(String carburant) {
        Carburant = carburant;
    }

    public Double getPutere() {
        return Putere;
    }

    public void setPutere(Double putere) {
        Putere = putere;
    }

    public String getITP() {
        return ITP;
    }

    public void setITP(String ITP) {
        this.ITP = ITP;
    }

    public String getAsigurare() {
        return Asigurare;
    }

    public void setAsigurare(String asigurare) {
        Asigurare = asigurare;
    }

    public String getTransmisie() {
        return transmisie;
    }

    public void setTransmisie(String transmisie) {
        this.transmisie = transmisie;
    }

    public String getAccident() {
        return accident;
    }

    public void setAccident(String accident) {
        this.accident = accident;
    }

    public Double getPretAchizitie() {
        return pretAchizitie;
    }

    public void setPretAchizitie(Double pretAchizitie) {
        this.pretAchizitie = pretAchizitie;
    }

    public VehiculeView() {
        super();
    }

    public VehiculeView(String idVehicul, String marca, String model, String categorie, String nrInmatriculare, Date dataInmatriculare, String anFabricatie, Double km, String tipMotor, String carburant, Double putere, String ITP, String asigurare, String transmisie, String accident, Double pretAchizitie) {
        this.idVehicul = idVehicul;
        this.marca = marca;
        this.model = model;
        this.categorie = categorie;
        this.nrInmatriculare = nrInmatriculare;
        this.dataInmatriculare = dataInmatriculare;
        this.anFabricatie = anFabricatie;
        this.km = km;
        this.tipMotor = tipMotor;
        Carburant = carburant;
        Putere = putere;
        this.ITP = ITP;
        Asigurare = asigurare;
        this.transmisie = transmisie;
        this.accident = accident;
        this.pretAchizitie = pretAchizitie;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getIdVehicul());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VehiculeView other = (VehiculeView) obj;
        if (idVehicul == null) {
            if (other.idVehicul != null)
                return false;
        } else if (!idVehicul.equals(other.idVehicul ))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VehiculeView{" +
                "idVehicul='" + idVehicul + '\'' +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", categorie='" + categorie + '\'' +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                ", dataInmatriculare=" + dataInmatriculare +
                ", anFabricatie='" + anFabricatie + '\'' +
                ", km=" + km +
                ", tipMotor='" + tipMotor + '\'' +
                ", Carburant='" + Carburant + '\'' +
                ", Putere=" + Putere +
                ", ITP='" + ITP + '\'' +
                ", Asigurare='" + Asigurare + '\'' +
                ", transmisie='" + transmisie + '\'' +
                ", accident='" + accident + '\'' +
                ", pretAchizitie=" + pretAchizitie +
                '}';
    }
}
