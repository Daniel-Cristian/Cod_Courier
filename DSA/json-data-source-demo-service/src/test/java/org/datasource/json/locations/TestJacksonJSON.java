package org.datasource.json.locations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import javax.json.bind.Jsonb;
//import javax.json.bind.JsonbBuilder;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJacksonJSON {
	private JSONFileDataSourceConnector fileDataSourceConnector;
	
	
	@Before
	public void setUp() throws Exception {
		this.fileDataSourceConnector = new JSONFileDataSourceConnector("DepartamentsCities.json");
	}

	@Test
	public void testReader() throws Exception{
		File jsonFile = fileDataSourceConnector.getJSONDoc();
//		Jsonb jsonb = JsonbBuilder.create();
//		DepartamentsListView dataViewBean = jsonb.fromJson(new FileReader(jsonFile), DepartamentsListView.class);
//		System.out.println(dataViewBean);
		
		ObjectMapper objectMapper = new ObjectMapper();
		DepartamentsListView dataViewBean = objectMapper.readValue(jsonFile, DepartamentsListView.class);
		
		System.out.println(dataViewBean);
	}
	
	@Test
	public void testWriter() throws Exception{
		DepartamentsListView departamentsListView = new DepartamentsListView();
		List<DepartamentView> listDepartamentView = new ArrayList<>();
		listDepartamentView.add(new DepartamentView(1l,"Iasi", "IS", "RO"));
		listDepartamentView.add(new DepartamentView(2l,"Neamt", "NT", "RO"));
		departamentsListView.setDepartaments(listDepartamentView);
		//
//		Jsonb jsonb = JsonbBuilder.create();
//		String jsonString = jsonb.toJson(departamentsListView);
//		System.out.println(jsonString);
//		//
//		DepartamentsListView departamentsListView2 = jsonb.fromJson(jsonString, DepartamentsListView.class);
//		System.out.println(departamentsListView2);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(departamentsListView);
		System.out.println(jsonString);
		//
		DepartamentsListView dataViewBean = objectMapper.readValue(jsonString, DepartamentsListView.class);
		System.out.println(dataViewBean);
	}
}
// https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
// https://www.ibm.com/developerworks/library/j-javaee8-json-binding-4/index.html
