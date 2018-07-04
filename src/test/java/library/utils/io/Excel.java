/**
 * @package org.nng.utils
 * @author Ashutosh Mishra [@github: nityanarayan44]
 * @desc Provides Excel file utility under "org.nng.automation.utils" package
 * 
 * ----------------------
 * Division of this class
 * ----------------------
 *  - Read an excel file as [Cell, Column, Row]
 *  - Write and create an excel file
 *  
 *  TODO: Documentation of this class and functions.
 */

package library.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class Excel {

	//=============================================================
	// Variables
	//=============================================================
		private String excelFilePath 		= null;
		private String excelFileType			= null;
		private FileInputStream inputStream 	= null;
		private FileOutputStream outputStream= null;
		private File file 					= null;
		private Workbook workbook 			= null;
		private Cell cell 					= null;
		private Row row 						= null;
	
		//XSSF For XLSX Files
		//HSSF for CSV, OLE2 files
	//=============================================================
	// cONSTRUCTOR
	//=============================================================
	public Excel(String excelFilePath) throws Exception {
			this.excelFilePath = ( this.validateExcelFile(excelFilePath) ) ? excelFilePath : null;
			if( (this.excelFileType).equalsIgnoreCase("xls") ) {
				this.initXLSStream();
			}
			else if( (this.excelFileType).equalsIgnoreCase("xlsx") ) {
				this.initXLSXStream();
			} 
	}
	
	//=============================================================
	// Functions
	//=============================================================
		
		/**
		 * @param excelFilePath
		 * @return boolean
		 * @throws Exception
		 * @desc validation of Excel file against its file extension
		 */
		public boolean validateExcelFile(String excelFilePath) throws Exception {
			boolean status = false;
			//check the extension of the given file.
			if (excelFilePath.endsWith("xlsx")) {		status = true; this.excelFileType = "xlsx"; }
			else if (excelFilePath.endsWith("xls")) { 	status = true; this.excelFileType = "xls"; }
			else {
				status = false;
				throw new IllegalArgumentException("The specified file is not Excel file");
			}
			//If all okay then globally set path for the excel file
			this.excelFilePath = excelFilePath;
			return status;
		}
		
		/**
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws Exception
		 * @desc Initialting XSSF workbook for excel file
		 */
		private void initXLSStream() throws FileNotFoundException, IOException, Exception {
			this.inputStream 	= new FileInputStream(this.excelFilePath);
			this.workbook 		= new HSSFWorkbook(this.inputStream);
		}
		
		/**
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws Exception
		 * @dessc Initating XSSF workbook for excel file
		 */
		private void initXLSXStream() throws FileNotFoundException, IOException, Exception {
			this.inputStream 	= new FileInputStream(this.excelFilePath);
			this.workbook 		= new XSSFWorkbook(this.inputStream);
		}
		
		/**
		 * @param sheetName
		 * @return boolean
		 * @throws Exception
		 * @desc Checks for sheet existence within the excel workbook,
		 * when Sheet Name is provided
		 */
		public boolean isSheetExist(String sheetName) throws Exception {
			return (this.workbook.getSheetIndex(sheetName) != -1) ? true : false;
		}
		
		/**
		 * @param sheetIndex
		 * @return boolean
		 * @throws Exception
		 * @desc Checks for sheet existence within the excel workbook,
		 * when Sheet index is provided
		 */
		public boolean isSheetExist(int sheetIndex) throws Exception {
			return (this.workbook.getSheetAt(sheetIndex) != null) ? true : false;
		}
		
		/**
		 * @param sheetName
		 * @return int
		 * @throws Exception
		 * @desc Returns the total number of row in a sheet,
		 * when sheet name is provided
		 */
		public int getRowCount(String sheetName) throws Exception {
			return ( (this.workbook.getSheet(sheetName)).getLastRowNum() - (this.workbook.getSheet(sheetName)).getFirstRowNum() ) + 1;		
		}
		
		/**
		 * @param sheetIndex
		 * @return int
		 * @throws Exception
		 * @desc Returns the total number of row in a sheet,
		 * when Sheet Index is provided
		 */
		public int getRowCount(int sheetIndex) throws Exception {
			return ( (this.workbook.getSheetAt(sheetIndex)).getLastRowNum() - (this.workbook.getSheetAt(sheetIndex)).getFirstRowNum() ) + 1;		
		}
		
		/**
		 * @param sheetName
		 * @param rowNum
		 * @param colNum
		 * @return String
		 * @throws Exception
		 * @desc Return cell data, specified by Row and Column index 
		 */
		public String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
			return ( (this.workbook.getSheet(sheetName)).getRow(rowNum) ).getCell(colNum).toString();
		}
		
		public String getCellData(int sheetIndex, int rowNum, int colNum) throws Exception {
			return ( (this.workbook.getSheetAt(sheetIndex)).getRow(rowNum) ).getCell(colNum).toString();
		}
		
		/**
		 * @param sheetName
		 * @param colName
		 * @return int
		 * @throws Exception
		 * @desc Return Column index[-1 if column not found], when column name is provided.
		 */
		public int getColumnIndex(String sheetName, String colName) throws Exception {
			int colIndex= -1;
			Row row 	= ( (this.workbook).getSheet(sheetName) ).getRow(0);
			for(int i=0; row != null && i<row.getLastCellNum(); i++) {
				if(row.getCell(i).toString().contains(colName))
					colIndex= row.getCell(i).getColumnIndex();
			}
			return colIndex;
		}
		
		/**
		 * @Overloaded
		 * @param sheetIndex
		 * @param colName
		 * @return int
		 * @throws Exception
		 * @desc Return Column index[-1 if column not found], when column name is provided.
		 */
		public int getColumnIndex(int sheetIndex, String colName) throws Exception {
			int colIndex= -1;
			Row row 	= ( (this.workbook).getSheetAt(sheetIndex) ).getRow(0);
			for(int i=0; row != null && i<row.getLastCellNum(); i++) {
				if(row.getCell(i).toString().contains(colName))
					colIndex= row.getCell(i).getColumnIndex();
			}
			return colIndex;
		}		
		
		/**
		 * @param sheetName
		 * @param rowIndex
		 * @return ArrayList<String>
		 * @throws Exception
		 * @desc Returns Row data as list, as Row index is Provided
		 */
		public ArrayList<String> getRowData(String sheetName, int rowIndex) throws Exception {
			Sheet objSheet 	= (this.workbook).getSheet(sheetName);
			ArrayList<String> columnData = new ArrayList<String>();
			Row row= objSheet.getRow(rowIndex);
			// Collecting all cell data in a Specified Column
			for(int i=0; i <= row.getLastCellNum(); i++) {
				if (row != null && row.getCell(i) != null)
					columnData.add( row.getCell(i).toString());		
			}
			// If excel is empty
			if(columnData.size() == 0) { columnData.add(""); }
			return columnData;
		}
		
		/**
		 * @param sheetIndex
		 * @param rowIndex
		 * @return ArrayList<String>
		 * @throws Exception
		 * @desc Return Row data as list, as Row index is provided
		 */
		public ArrayList<String> getRowData(int sheetIndex, int rowIndex) throws Exception{
			Sheet objSheet 	= (this.workbook).getSheetAt(sheetIndex);
			ArrayList<String> columnData = new ArrayList<String>();
			Row row= objSheet.getRow(rowIndex);
			// Collecting all cell data in a Specified Column
			for(int i=0; i <= row.getLastCellNum(); i++) {
				if (row != null && row.getCell(i) != null)
					columnData.add( row.getCell(i).toString());		
			}
			// If excel is empty
			if(columnData.size() == 0) { columnData.add(""); }
			return columnData;
		}
				
		/**
		 * @param sheetName
		 * @param colName
		 * @return ArrayList<String>
		 * @throws Exception
		 * @desc Returns column data as list, If Column name is provided
		 */
		public ArrayList<String> getColumnData(String sheetName, String colName) throws Exception{
			Row row 		= null;
			Sheet objSheet 	= (this.workbook).getSheet(sheetName);
			int rowCount 	= this.getRowCount(sheetName);
			int colIndex 	= this.getColumnIndex(sheetName, colName);
			ArrayList<String> columnData = new ArrayList<String>();
			columnData.add("");
			// Collecting all cell data in a Specified Column
			for(int i=1; i<rowCount+1; i++) {
				row = objSheet.getRow(i);
				if (row != null && row.getCell(colIndex) != null)
					columnData.add( row.getCell(colIndex).toString());		
			}
			return columnData;
		}
		
		/**
		 * @Overloaded
		 * @param sheetIndex
		 * @param colName
		 * @return ArrayList<String>
		 * @throws Exception
		 * @Desc Return column data as list, If sheet Index and Column index is known
		 */
		public ArrayList<String> getColumnData(int sheetIndex, String colName) throws Exception {
			Sheet objSheet 	= (this.workbook).getSheetAt(sheetIndex);
			int rowCount 	= this.getRowCount(sheetIndex);
			int colIndex 	= this.getColumnIndex(sheetIndex, colName);
			Row row 		= null;
			ArrayList<String> columnData = new ArrayList<String>();
			//columnData.add("-[LIST]-");
			// Collecting all cell data in a Specified Column
			for(int i=1; i<rowCount+1; i++) {
				row = objSheet.getRow(i);
				if (row != null && row.getCell(colIndex) != null) {
					//System.out.println(">>> I="+ i + ", " + row.getCell(colIndex));
					columnData.add( row.getCell(colIndex).toString() );
				}
			}
			return columnData;
		}
		
		/**
		 * @param sheetName
		 * @param colIndex
		 * @return ArrayList<String>
		 * @throws Exception
		 * @desc Return column data as list, If Column index is provided
		 */
		public ArrayList<String> getColumnData(String sheetName, int colIndex) throws Exception {
			Row row 		= null;
			Sheet objSheet 	= (this.workbook).getSheet(sheetName);
			int rowCount 	= this.getRowCount(sheetName);
			ArrayList<String> columnData = new ArrayList<String>();
			// Collecting all cell data in a Specified Column
			for(int i=1; i<rowCount+1; i++) {
				row = objSheet.getRow(i);
				if (row != null && row.getCell(colIndex) != null)
					columnData.add( row.getCell(colIndex).toString());	
			}
			return columnData;
		}
		
		/**
		 * @param sheetIndex
		 * @param colIndex
		 * @return ArrayList<String>
		 * @throws Exception
		 * @Desc Return column data as list, If sheet Index and Column index is known
		 */
		public ArrayList<String> getColumnData(int sheetIndex, int colIndex) throws Exception {
			Sheet objSheet 	= (this.workbook).getSheetAt(sheetIndex);
			int rowCount 	= this.getRowCount(sheetIndex);
			Row row 		= null;
			ArrayList<String> columnData = new ArrayList<String>();
			//columnData.add("-[LIST]-");
			// Collecting all cell data in a Specified Column
			for(int i=1; i<rowCount+1; i++) {
				row = objSheet.getRow(i);
				if (row != null && row.getCell(colIndex) != null) {
					//System.out.println(">>> I="+ i + ", " + row.getCell(colIndex));
					columnData.add( row.getCell(colIndex).toString() );
				}
			}
			return columnData;
		}
		
		/**
		 * @param sheetIndex
		 * @throws Exception
		 * @desc Prints the entire excel sheet,
		 * when sheet index is provided
		 */
		public void printExcelSheet(int sheetIndex) throws Exception {
			Row row 		= null;
			Sheet objSheet 	= (this.workbook).getSheetAt(sheetIndex);
			int rowCount 	= this.getRowCount(sheetIndex);
			for(int loopi=0; loopi < rowCount+1; loopi++) {
				row = objSheet.getRow(loopi);
				System.out.print(" | ");
				for(int loopj=0; (row != null && row.getCell(loopj) != null) && loopj < row.getLastCellNum(); loopj++) {
					System.out.print(row.getCell(loopj).toString() + " | "); 
				} System.out.println(" |");
			}
		}
		
		/**
		 * @param sheetName
		 * @throws Exception
		 * @desc print the Excel entire sheet,
		 * when sheet name is provided
		 */
		public void printExcelSheet(String sheetName) throws Exception {
			Row row 		= null;
			Sheet objSheet 	= (this.workbook).getSheet(sheetName);
			int rowCount 	= this.getRowCount(sheetName);
			for(int loopi=0; loopi < rowCount+1; loopi++) {
				row = objSheet.getRow(loopi);
				System.out.print(" | ");
				for(int loopj=0; (row != null && row.getCell(loopj) != null) && loopj < row.getLastCellNum(); loopj++) {
					System.out.print(row.getCell(loopj).toString() + " | "); 
				} System.out.println(" |");
			}
		}
		
		/*
		 *  Writing to a cell in current Excel File
		 */
		public void setDataToCell(int sheetIndex, int rowIndex, int columnIndex, String value) throws IOException, Exception {
			Row row 		= null;
			Sheet objSheet 	= (this.workbook).getSheetAt(sheetIndex);
			row = objSheet.getRow(1);
			objSheet.getRow(rowIndex).createCell(columnIndex).setCellValue(value);
			//Writing data to a specified cell.
			this.outputStream = new FileOutputStream(this.excelFilePath);
			workbook.write(outputStream);			
			outputStream.close();	
			return;
		}
		
		/*
		 * Close the current FileStream.
		 */
		public void closeFileStreams() throws Exception{
			if(this.inputStream != null) this.inputStream.close();
			if(this.outputStream != null) this.outputStream.close();
			return;
		}
		
}/* End of Class */