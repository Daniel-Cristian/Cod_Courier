package org.datasource.json.locations;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Base64;

public class JSONWebDataSourceConnector extends JSONFileDataSourceConnector{
	
	public JSONWebDataSourceConnector(String docName) {
		super(docName);
	}
	
	private String basicAuth = null;
	public JSONWebDataSourceConnector(String docName, String username, String password) {
		super(docName);
		
		if (username != null && password != null) {
			String userpass = username + ":" + password;
			basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
		}
			
	}
	
	public File getJSONDoc() throws Exception {
		if (inputFile == null) {
			URL url = new URL(JSONDocPath);
			URLConnection uc = url.openConnection();
			if (basicAuth != null) {
				uc.setRequestProperty ("Authorization", basicAuth);
			}
			// download from Web server
			try(InputStream inputStream = uc.getInputStream()){
				inputFile = new File("downloaded_doc.json");
				if (inputFile.exists()) {
					inputFile.delete();
					inputFile = new File("downloaded_doc.json");
				}
				Files.copy(inputStream, inputFile.toPath());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return inputFile;
	}
}