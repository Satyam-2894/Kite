package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Util {

	public static String getDataFromSheet(int row, int col) throws EncryptedDocumentException, IOException  {
		String data = null;

		String path="D:\\KITE.xlsx";

		FileInputStream file=new FileInputStream(path);

		try
		{
			data =  WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double d = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getNumericCellValue();
			data=String.valueOf(d);
			
		}
		catch(NullPointerException g)
		{
			System.out.println("cell is Blank");
		}
		catch(Exception c)
		{
			c.printStackTrace();	
		}
		return data;
	}
	
	
	 public static String getDataFromFile(int row, int col) throws FileNotFoundException{
			String data = null;
			String path="D:\\KITE.xlsx";
			FileInputStream file=new FileInputStream(path);
			try
			{
			double	num=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(col).getNumericCellValue();
			data=String.valueOf(num);
				return data;
			}
			catch(NullPointerException a)
			
			{
				System.out.println("cell is blank");
			}
			catch(Exception c)
			{
				c.getStackTrace();
			}
			return data;

	 }
	
	public static void saveScreenshot(WebDriver driver,int testID) throws IOException {

		Date d = new Date(testID);
		String s1=d.toString().replace(":", "-").replace(" ", "-");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\satyam\\screenshot"+testID+s1+".jpg");
		FileHandler.copy(source, destination);
		
	}

}

