package UserDefinedPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
 
	
	public static XSSFSheet sheet;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static FileInputStream fileip;
	public static String exfilepath=System.getProperty("user.dir")+"\\testdata\\MyData.xlsx";
   public static String[] category=new String[2];
   
   
   public static String[] readexcel() throws Exception {
		try {
			 
		     fileip=new FileInputStream(exfilepath);
			 workbook=new XSSFWorkbook(fileip);
			 sheet=workbook.getSheetAt(0);
			
			category[0]=sheet.getRow(0).getCell(0).toString();
			category[1]=sheet.getRow(1).getCell(0).toString();
			workbook.close();
			fileip.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
		
		
		return category;
	}
    public static void writeexcel(){
		try {
			fileop=new FileOutputStream(exfilepath);
			/*workbook=new XSSFWorkbook();
			sheet=workbook.getSheet("MyData1.xlsx");
			sheet.createRow(1).createCell(0).setCellValue(err);*/
			workbook.write(fileop);
			fileop.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
