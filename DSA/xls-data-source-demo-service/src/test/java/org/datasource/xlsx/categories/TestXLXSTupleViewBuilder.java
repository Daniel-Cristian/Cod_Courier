package org.datasource.xlsx.categories;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestXLXSTupleViewBuilder {

	private XLXSTupleViewBuilder tupleViewBuilder;
	private XLSXFileDataSourceConnector dataSourceConnector;
	
	@Before
	public void setUp() throws Exception {
		this.dataSourceConnector = new XLSXFileDataSourceConnector("CustProdCateg.xlsx");
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "CTG_CUST_TO");
	}

	@Test
	public void testXLXSTupleViewBuilder() throws Exception{
		List<Map<String, Object>> tuples = this.tupleViewBuilder.build().getTupleList();
		
		assertTrue("None XLSX Data!", tuples.size() > 0);
		
		for (Map<String, Object> tuple: tuples)
			System.out.println(tuple);		
	}

	@Test
	public void testXLXSTupleViewBuilderNamedSheet1() throws Exception{
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "CTG_CUST_TO");
		
		List<Map<String, Object>> tuples = this.tupleViewBuilder.build().getTupleList();
		
		assertTrue("None XLSX Data!", tuples.size() > 0);
		
		for (Map<String, Object> tuple: tuples)
			System.out.println(tuple);		
	}
	
	@Test
	public void testXLXSTupleViewBuilderNamedSheet2() throws Exception{
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "CTG_CUST_EMP");
		
		List<Map<String, Object>> tuples = this.tupleViewBuilder.build().getTupleList();
		
		assertTrue("None XLSX Data!", tuples.size() > 0);
		
		for (Map<String, Object> tuple: tuples)
			System.out.println(tuple);		
	}
	
	@Test
	public void testXLXSTupleViewBuilderNamedSheet3() throws Exception{
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "PERIODS");
		
		List<Map<String, Object>> tuples = this.tupleViewBuilder.build().getTupleList();
		
		assertTrue("None XLSX Data!", tuples.size() > 0);
		
		for (Map<String, Object> tuple: tuples)
			System.out.println(tuple);		
	}	
}
