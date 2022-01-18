package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrive {
	

public ArrayList<String> GetData(String TestcaseName) throws IOException
{
	ArrayList<String> a=new ArrayList<String>();
	FileInputStream fil=new FileInputStream(".//DataExcel//Excel.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fil);
	//selecting particular sheet in excel
	int NumberSheets = workbook.getNumberOfSheets();
for(int i=0; i<NumberSheets;i++)
{
	if(workbook.getSheetName(i).equalsIgnoreCase("SHEET"))
	{
		XSSFSheet sheet = workbook.getSheetAt(i);//open sheet of i index
	Iterator<Row> rows = sheet.iterator();//access to the rows
	Row firstrow = rows.next();
	Iterator<Cell> cl = firstrow.cellIterator();
	int column=0;
	int k = 0;
	while(cl.hasNext())
	{
		Cell value = cl.next();
		if(value.getStringCellValue().equalsIgnoreCase("TEST CASES"))
		{
			column=k;
		}
		k++;
	}
	System.out.println(column);
		while(rows.hasNext())
			{
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
					{
						Iterator<Cell> cv = r.cellIterator();
					while(cv.hasNext())
					{
						Cell c = cv.next();
						a.add(c.getStringCellValue().toString());
					}
					}
					
				
			}
		}
	}
	
}
return a;
}
public static void main(String[] args)throws IOException{

}
}
