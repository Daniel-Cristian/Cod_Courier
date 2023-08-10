package org.xls.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSDataReader {
	
	private XLSFileDataSourceConnector dataSourceConnector;
	
	public XLSDataReader() throws FileNotFoundException {
		super();
		this.dataSourceConnector = new XLSFileDataSourceConnector();
	}

	public XLSDataReader(XLSFileDataSourceConnector dataSourceConnector) {
		super();
		this.dataSourceConnector = dataSourceConnector;
	}

	public void readXLSData() throws Exception{
		FileInputStream file = dataSourceConnector.getXLSFile();

		// Get Workbook
		//XSSFWorkbook workbook = new XSSFWorkbook(file);
		try(Workbook workbook = new XSSFWorkbook(file)){
		
			System.out.println("Open workbook: " + dataSourceConnector.getXLSFilePath());
			//XSSFSheet sheet;
			Sheet sheet;
	
			
			// Iterator<XSSFSheet> iSheet = workbook.iterator();
			for(Sheet lSheet: workbook)
				System.out.println("Found worksheet: " + lSheet.getSheetName());
			
			/*
			Iterator<Sheet> iSheet = workbook.iterator();
			while(iSheet.hasNext()){
				sheet = iSheet.next();
				System.out.println("Found worksheet: " + sheet.getSheetName());
			}
			*/
			
			for(int i=0; i < workbook.getNumberOfSheets(); i++){
				sheet = workbook.getSheetAt(i);
				//System.out.println("Found worksheet: " + sheet.getSheetName());
				readSheetData(sheet);
			}
		}

		file.close();
	}
	
	//private void readSheetData(XSSFSheet sheet) throws Exception{
	private void readSheetData(Sheet sheet) throws Exception{
		System.out.println("========================================");
		//Iterate through each rows one by one
        //Iterator<Row> rowIterator = sheet.iterator();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //while (rowIterator.hasNext()) {
        //    Row row = rowIterator.next();
        for(Row row: sheet) {
            //For each row, iterate through all the columns
            //Iterator<Cell> cellIterator = row.cellIterator();
             
            //while (cellIterator.hasNext()) {
            //    Cell cell = cellIterator.next();
            for(Cell cell: row) {
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                    // case Cell.CELL_TYPE_NUMERIC:
                	case NUMERIC:
                    {
                        if (HSSFDateUtil.isCellDateFormatted(cell)){
                        	Date dateValue = cell.getDateCellValue();
                        	System.out.print(dateFormat.format(dateValue) + " ");
                        }else
                        	System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    }
                    // case Cell.CELL_TYPE_STRING:
                	case STRING:
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                        
                }
            }
            System.out.println("");
        }
        System.out.println("========================================");
	}
}

class XLSFileDataSourceConnector {
	private String XLSFilePath;
	private File file;
	
	public String getXLSFilePath() {
		return XLSFilePath;
	}

	public XLSFileDataSourceConnector() throws FileNotFoundException {
		// this.XLSFilePath = "src/main/resources/CustProdCateg.xlsx";
		this("CustProdCateg.xlsx");
	}

	public XLSFileDataSourceConnector(String xLSFilePath) throws FileNotFoundException {
		this.XLSFilePath = xLSFilePath;
		this.file = new File(XLSFilePath);
	}

	public FileInputStream getXLSFile() throws Exception {
		return new FileInputStream(this.file);
	}
}