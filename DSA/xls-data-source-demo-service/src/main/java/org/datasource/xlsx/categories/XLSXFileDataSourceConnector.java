package org.datasource.xlsx.categories;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXFileDataSourceConnector {
	protected String XLSFilePath;
	protected XSSFWorkbook workbook;
	protected File XLSfile;
	
	public String getXLSFilePath() {
		return XLSFilePath;
	}

	public XLSXFileDataSourceConnector(String xLSFilePath) throws Exception{
		this.XLSFilePath = xLSFilePath;
	}	

	public File getXLSXFile() throws Exception {
		if (XLSfile == null) {
			this.XLSfile = new File(this.XLSFilePath);
			this.workbook = new XSSFWorkbook(this.XLSfile);
		}
		return this.XLSfile;
	}
	
	public FileInputStream getXLSXFileInputStream() throws Exception {
		return new FileInputStream(this.getXLSXFile());
	}
}
