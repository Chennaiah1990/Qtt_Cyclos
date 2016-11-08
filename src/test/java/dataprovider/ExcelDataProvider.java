package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File("./AppplicationTestData/TestData.xlsx")));
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	/*public int getNumericData(int sheetIndex, int row, int col)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
	}*/

}
