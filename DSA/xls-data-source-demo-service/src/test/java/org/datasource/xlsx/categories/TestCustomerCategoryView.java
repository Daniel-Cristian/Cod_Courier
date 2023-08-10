package org.datasource.xlsx.categories;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestCustomerCategoryView {

	private XLXSTupleViewBuilder tupleViewBuilder;
	private XLSXFileDataSourceConnector dataSourceConnector;
	private CustomerCategoriesViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		this.dataSourceConnector = new XLSXFileDataSourceConnector("CustProdCateg.xlsx");
		
		
	}

	@Test
	public void test_CTG_CUST_TO() throws Exception{
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "CTG_CUST_TO");
		this.viewBuilder = new CustomerCategoriesViewBuilder(tupleViewBuilder);
		
		List<CustomerCategoryView> viewList = this.viewBuilder.build().getCategoriesList();
		System.out.println("==================" + "CustomerCategoriesViewBuilder" + " ======================");
		assertTrue("Get CustomerCategoryView Data failed!", viewList.size() > 0);
		for(CustomerCategoryView viewDta: viewList)
			System.out.println(viewDta);
		
	}
	
	@Test
	public void test_CTG_CUST_EMP() throws Exception{
		this.tupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "CTG_CUST_EMP");
		this.viewBuilder = new CustomerCategoriesViewBuilder(tupleViewBuilder);
		
		List<CustomerCategoryView> viewList = this.viewBuilder.build().getCategoriesList();
		System.out.println("==================" + "CustomerCategoriesViewBuilder" + " ======================");
		assertTrue("Get CustomerCategoryView Data failed!", viewList.size() > 0);
		for(CustomerCategoryView viewDta: viewList)
			System.out.println(viewDta);
		
	}	

}
