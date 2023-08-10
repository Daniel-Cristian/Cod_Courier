package org.datasource.xlsx;

import org.datasource.xlsx.categories.TestCustomerCategoryView;
import org.datasource.xlsx.categories.TestTimePeriodView;
import org.datasource.xlsx.categories.TestXLXSTupleViewBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.xls.example.TestXLSDataReader;

@RunWith(Suite.class)
@SuiteClasses({ TestXLSDataReader.class, TestCustomerCategoryView.class, 
	TestXLXSTupleViewBuilder.class, TestTimePeriodView.class})
public class All_XLS_Tests {

}
