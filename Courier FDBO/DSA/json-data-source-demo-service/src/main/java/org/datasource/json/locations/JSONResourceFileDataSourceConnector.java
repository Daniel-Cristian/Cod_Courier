package org.datasource.json.locations;

public class JSONResourceFileDataSourceConnector extends JSONFileDataSourceConnector{
	private static String BASE_PATH = "";
	
	public JSONResourceFileDataSourceConnector(String docName) {
		super(BASE_PATH + docName);
	}
	
}




//"O:\\Professional\\IIWebData\\GitLab\\sdbis-data.integration-ref\\json-data-source-demo\\";