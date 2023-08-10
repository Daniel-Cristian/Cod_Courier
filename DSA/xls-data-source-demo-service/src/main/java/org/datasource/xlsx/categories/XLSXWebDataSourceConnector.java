package org.datasource.xlsx.categories;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

public class XLSXWebDataSourceConnector extends XLSXFileDataSourceConnector{
	
	public XLSXWebDataSourceConnector(String filePathName)  throws Exception{
		super(filePathName);
	}
	
	public File getXLSXFile() throws Exception {
		if (XLSfile == null) {
			// download from FTP server
			try(InputStream inputStream = new URL(XLSFilePath).openConnection().getInputStream()){
				XLSfile = new File("downloaded_doc.xlsx");
				if (XLSfile.exists()) {
					XLSfile.delete();
					XLSfile = new File("downloaded_doc.xlsx");
				}
				Files.copy(inputStream, XLSfile.toPath());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return XLSfile;
	}
}


//"D:\\Professional\\IIWebData\\GitLab\\sdbis-data.integration-ref\\xls-data-source-demo\\";
