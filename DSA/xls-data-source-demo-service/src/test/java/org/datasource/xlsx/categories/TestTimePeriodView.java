package org.datasource.xlsx.categories;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTimePeriodView {

	private XLXSTupleViewBuilder tupleViewBuilder;
	private XLSXFileDataSourceConnector dataSourceConnector;
	private TimePeriodViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		this.dataSourceConnector = new XLSXFileDataSourceConnector("CustProdCateg.xlsx");
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "Periods");
		this.viewBuilder = new TimePeriodViewBuilder(tupleViewBuilder);		
		
	}

	@Test
	public void test_TimePeriodViewBuilder() throws Exception{
		List<TimePeriodView> viewList = this.viewBuilder.build().getPeriodsList();
		System.out.println("==================" + "TimePeriodViewBuilder" + " ======================");
		assertTrue("Get TimePeriodView Data failed!", viewList.size() > 0);
		for(TimePeriodView viewDta: viewList)
			System.out.println(viewDta);
	}

}
