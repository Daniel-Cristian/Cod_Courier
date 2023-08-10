package org.xls.example;

import org.junit.Before;
import org.junit.Test;

public class TestXLSDataReader {
	private XLSDataReader xlsDataReader;

	@Before
	public void setUp() throws Exception {
		this.xlsDataReader = new XLSDataReader();
	}

	@Test
	public void test() throws Exception{
		System.out.println("TESTING: TestXLSDataReader");
		xlsDataReader.readXLSData();
	}

}