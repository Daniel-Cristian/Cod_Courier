package org.datasource.xlsx.categories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class VehiculeViewBuilder {
    // Data Cache
    private List<VehiculeView> vehiculeList;
    private List<Map<String, Object>> vehiculeTupleList; // lista de tupluri
    public List<VehiculeView> getVehiculeList() {
        return vehiculeList;
    }
    public List<Map<String, Object>> getvehiculeTupleList() {
        return vehiculeTupleList;
    }

    // Pre-builders
    private XLXSTupleViewBuilder tupleViewBuilder;
    public VehiculeViewBuilder(XLXSTupleViewBuilder tupleViewBuilder) {
        super();
        this.tupleViewBuilder = tupleViewBuilder;
    }

    // Builder Workflow
    public VehiculeViewBuilder build() throws Exception{
        return this.select().map();
    }

    public VehiculeViewBuilder select() throws Exception{
        this.vehiculeTupleList = this.tupleViewBuilder.build().getTupleList();
        return this;
    }

    private VehiculeViewListAdapter viewListAdapter = new VehiculeViewListAdapter();
    public VehiculeViewBuilder map() throws Exception{
        this.vehiculeList = this.viewListAdapter.map(vehiculeTupleList);
        return this;
    }
}

class VehiculeViewListAdapter{
    private VehiculeViewAdapter viewAdaptor = new VehiculeViewAdapter();

    public List<VehiculeView> map(List<Map<String, Object>> tupleList){
        List<VehiculeView> viewList = new ArrayList<>();
        for (Map<String, Object> tuple: tupleList)
            viewList.add(this.viewAdaptor.map(tuple));
        return viewList;
    }
}

class VehiculeViewAdapter{
    public VehiculeView map(Map<String, Object> tuple){
        return new VehiculeView(
                tuple.get("ID_VEHICUL").toString(),
                tuple.get("MARCA").toString(),
                tuple.get("MODEL").toString(),
                tuple.get("CATEGORIE_VEHICUL").toString(),
                tuple.get("NR_INMATRICULARE").toString(),
                (Date) tuple.get("DATA_INMATRICULARE"),
                tuple.get("AN_FABRICATIE").toString(),
                Double.valueOf(tuple.get("KM").toString()),
                tuple.get("TIP_MOTOR").toString(),
                tuple.get("CARBURANT").toString(),
                Double.valueOf(tuple.get("PUTERE").toString()),
                tuple.get("PROBLEME_TEHNICE").toString(),
                tuple.get("ITP_VALABIL").toString(),
                tuple.get("TIP_TRANSMISIE").toString(),
                tuple.get("ISTORIC_ACCIDENT").toString(),
                Double.valueOf(tuple.get("PRET_ACHIZITIE").toString())
        );
    }
}