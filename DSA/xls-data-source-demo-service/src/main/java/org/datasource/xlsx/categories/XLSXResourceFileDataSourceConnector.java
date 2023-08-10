package org.datasource.xlsx.categories;

public class XLSXResourceFileDataSourceConnector extends XLSXFileDataSourceConnector{
	private static String BASE_PATH = "";
	
	public XLSXResourceFileDataSourceConnector(String fileName)  throws Exception{
		super(BASE_PATH + fileName);
	}
}


//"D:\\Professional\\IIWebData\\GitLab\\sdbis-data.integration-ref\\xls-data-source-demo\\";
