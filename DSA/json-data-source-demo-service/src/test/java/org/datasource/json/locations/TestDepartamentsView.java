package org.datasource.json.locations;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestDepartamentsView {
	private CategoriiViewBuilder viewBuilder;
	private JSONFileDataSourceConnector fileDataSourceConnector;
	
	
	@Before
	public void setUp() throws Exception {
		this.fileDataSourceConnector = new JSONFileDataSourceConnector("DepartamentsCities.json");
	}
	
	@Test
	public void testCategoriiViewBuilder() throws Exception{
	    this.viewBuilder = new CategoriiViewBuilder(fileDataSourceConnector);
		//
		List<CategorieView> viewList = this.viewBuilder.build().getCategoriiViewList();
		System.out.println("==================" + "DepartamentsViewBuilderJAXB DEPARTAMENTS" + " ======================");
		assertTrue("Get DepartamentView Data failed!", viewList.size() > 0);
		for(CategorieView categorie: viewList)
			System.out.println(categorie);
		//
		System.out.println("==================" + "DepartamentsViewBuilderJAXB CITIES" + " ======================");
		List<ColetView> coleteViewList = this.viewBuilder.getColeteViewList();
		for(ColetView ciy: coleteViewList)
			System.out.println(ciy);
		
	}	

}
