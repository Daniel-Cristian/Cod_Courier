package org.datasource.json.locations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.datasource.json.locations.CategorieView;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "categorii")
@JsonIgnoreProperties({"_id"})
public class CategoriiListView {
    List<CategorieView> categorii = new ArrayList<>();

    @XmlElement(name="categorie")
    public List<CategorieView> getCategorii() {
        return categorii;
    }

    public void setCategorii(List<CategorieView> categorii) {
        this.categorii = categorii;
    }

    @Override
    public String toString() {
        return "CategoriiView [categorii=" + categorii + "]";
    }
}