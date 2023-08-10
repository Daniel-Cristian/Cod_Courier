package org.datasource.json.locations;

import java.io.File;

public class JSONFileDataSourceConnector {
	protected String JSONDocPath;
	protected File inputFile;

	public JSONFileDataSourceConnector(String docName) {
		this.JSONDocPath  = docName;
		
	}

	public File getJSONDoc() throws Exception {
		if (inputFile == null)
			this.inputFile = new File(this.JSONDocPath);
		return inputFile;
	}
}
