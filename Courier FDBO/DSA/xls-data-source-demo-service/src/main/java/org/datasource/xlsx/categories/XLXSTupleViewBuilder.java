package org.datasource.xlsx.categories;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXSTupleViewBuilder {
	private List<Map<String, Object>> tupleList;
	private ListTupleAdaptor listTupleAdaptor;
	//
	private XLSXFileDataSourceConnector dataSourceConnector;
	private XSSFWorkbook workbook;
	private XSSFSheet worksheet;
	private String worksheetName;
	//
	public XLXSTupleViewBuilder(XLSXFileDataSourceConnector dataSourceConnector) throws Exception{
		super();
		this.dataSourceConnector = dataSourceConnector;
		FileInputStream file = this.dataSourceConnector.getXLSXFileInputStream();
		this.workbook = new XSSFWorkbook(file);
		//
		this.worksheet = this.workbook.getSheetAt(0);
	}
	public XLXSTupleViewBuilder(XLSXFileDataSourceConnector dataSourceConnector, String worksheetName) throws Exception{
		this(dataSourceConnector);
		this.worksheetName = worksheetName;
		this.worksheet = this.workbook.getSheet(this.worksheetName);
	}
	
	
	public List<Map<String, Object>> getTupleList() {
		return tupleList;
	}
	
	// Building process
	public XLXSTupleViewBuilder build() throws Exception {
		return this.select().map();
	}
	
	
	public XLXSTupleViewBuilder select() throws Exception {
		this.listTupleAdaptor = new ListTupleAdaptor();
		this.worksheetName = this.worksheet.getSheetName();
		return this;
	}

	public XLXSTupleViewBuilder map() throws Exception {
		this.tupleList = this.listTupleAdaptor.map(worksheet);
		return this;
	}	
}

class ListTupleAdaptor{
	private TupleAdaptor tupleAdaptor = new TupleAdaptor();
	
	public List<Map<String, Object>> map(XSSFSheet sheet){
		List<Map<String, Object>> tuples = new ArrayList<>();
		List<String> sheetHeader = getSheetHeader(sheet);
		
		System.out.println("==== HEADER: " + sheetHeader);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() > 0) // Not processing header
             tuples.add(tupleAdaptor.map(row, sheetHeader));
        }
		
		return tuples;
	}
	
	private List<String> getSheetHeader(XSSFSheet sheet){
		List<String> sheetHeader = new ArrayList<>();
		Integer rowHeaderNumber = 0;
		Row row = sheet.getRow(rowHeaderNumber);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			/*
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue() + " ");
				case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue() + " ");
			}
			*/
			sheetHeader.add(cell.getStringCellValue());
		}
		return sheetHeader;
	}
}

class TupleAdaptor{
	public Map<String, Object> map(Row row, List<String> sheetHeader){
		Map<String, Object> tuple = new HashMap<>();
		
		List<Object> rowValues = new ArrayList<>();
		Iterator<Cell> cellIterator = row.cellIterator();
        // get row values
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            // cell value types
            switch (cell.getCellType()) {
                // case Cell.CELL_TYPE_NUMERIC:
            	case NUMERIC:
                {
                    if (HSSFDateUtil.isCellDateFormatted(cell)){
                    	Date dateValue = cell.getDateCellValue();
                    	// Date
                    	rowValues.add(dateValue);
                    }else{
                    	// Number
                    	Number numberValue = cell.getNumericCellValue();
                    	rowValues.add(numberValue);
                    	//System.out.println("Effective number type: " + numberValue.getClass().getName());
                    }
                    break;
                }
                // case Cell.CELL_TYPE_STRING:
            	case STRING:
                {
                    // Plain String
                	String stringValue = cell.getStringCellValue();
                	rowValues.add(stringValue);
                    break;
                }
                    
            }
        }
        // build tuple
        for (int i=0; i < sheetHeader.size(); i++){
        	tuple.put(sheetHeader.get(i), rowValues.get(i));
        }
        return tuple;
	}
}