package org.datasource.json.locations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class CategoriiViewBuilder {
    // Data cache
    private CategoriiListView categoriiListView;
    private List<CategorieView> categoriiViewList;
    private List<ColetView> coleteViewList;

    public List<CategorieView> getCategoriiViewList() {
        return categoriiViewList;
    }

    public List<ColetView> getColeteViewList() {
        return coleteViewList;
    }

    public CategoriiListView getCategoriiListView() {
        return categoriiListView;
    }



    // Support Infrastructure
    private JSONFileDataSourceConnector dataSourceConnector;
    private File jsonFile;

    public CategoriiViewBuilder(JSONFileDataSourceConnector dataSourceConnector) throws Exception {
        //dataSourceConnector = new XMLFileDataSourceConnector();
        this.dataSourceConnector = dataSourceConnector;
        jsonFile = dataSourceConnector.getJSONDoc();
    }


    // Builder Workflow
    public CategoriiViewBuilder build() throws Exception{
        return this.select().map();
    }


    private CategoriiViewBuilder map() {
        this.categoriiViewList = this.categoriiListView.getCategorii();
        this.coleteViewList = new ArrayList<>();

        for(CategorieView categorieView: categoriiViewList){
            for (ColetView coletView: categorieView.getColete())
                coletView.setCategorie(categorieView);
            this.coleteViewList.addAll(categorieView.getColete());
        }

        return this;
    }


    public CategoriiViewBuilder select() throws Exception {
        //Jsonb jsonb = JsonbBuilder.create();
        //this.departamentsListView = jsonb.fromJson(new FileReader(jsonFile), DepartamentsListView.class);
        ObjectMapper objectMapper = new JsonMapper();
        this.categoriiListView = objectMapper.readValue(jsonFile, CategoriiListView.class);

        return this;
    }
}