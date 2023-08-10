package org.datasource.xlsx.categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DestinatariViewBuilder {
    // Data Cache
    private List<DestinatariView> destinatariList;
    private List<Map<String, Object>> destinatariTupleList; // lista de tupluri
    public List<DestinatariView> getDestinatariList() {
        return destinatariList;
    }
    public List<Map<String, Object>> getDestinatariTupleList() {
        return destinatariTupleList;
    }

    // Pre-builders
    private XLXSTupleViewBuilder tupleViewBuilder;
    public DestinatariViewBuilder(XLXSTupleViewBuilder tupleViewBuilder) {
        super();
        this.tupleViewBuilder = tupleViewBuilder;
    }

    // Builder Workflow
    public DestinatariViewBuilder build() throws Exception{
        return this.select().map();
    }

    public DestinatariViewBuilder select() throws Exception{
        this.destinatariTupleList = this.tupleViewBuilder.build().getTupleList();
        return this;
    }

    private DestinatariViewListAdapter viewListAdapter = new DestinatariViewListAdapter();
    public DestinatariViewBuilder map() throws Exception{
        this.destinatariList = this.viewListAdapter.map(destinatariTupleList);
        return this;
    }
}

class DestinatariViewListAdapter{
    private DestinatariViewAdapter viewAdaptor = new DestinatariViewAdapter();

    public List<DestinatariView> map(List<Map<String, Object>> tupleList){
        List<DestinatariView> viewList = new ArrayList<>();
        for (Map<String, Object> tuple: tupleList)
            viewList.add(this.viewAdaptor.map(tuple));
        return viewList;
    }
}

class DestinatariViewAdapter{
    public DestinatariView map(Map<String, Object> tuple){
        return new DestinatariView(
                tuple.get("ID_DESTINATAR").toString(),
                tuple.get("NUME").toString(),
                tuple.get("PRENUME").toString(),
                tuple.get("ADRESA").toString(),
                tuple.get("MEDIU").toString(),
                tuple.get("COD_POSTAL").toString(),
                tuple.get("NR_TELEFON").toString()
        );
    }
}