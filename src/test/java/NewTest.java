
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class NewTest {
	WebDriver driver;
	@Test(dataProvider ="Datafatch")
  public void f(String username,String password) throws InterruptedException {
	  
	    driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		WebElement gmail =driver.findElement(By.xpath("//input[@type='email']"));
		gmail.sendKeys(username);
		gmail.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		WebElement passwords =driver.findElement(By.xpath("//input[@type='password']"));
		passwords.sendKeys(password);
		passwords.sendKeys(Keys.ENTER);
		//driver.quit();
		
  }
	@DataProvider(name="Datafatch")
	public Object[][] definepath() throws IOException{
		String filelocation ="/Users/yogeshadke/Documents/Gmaillogin.xlsx";
		Object[][] getdata = getExcelData(filelocation,"credentials");
		return getdata;
		
	}
	public String [][]getExcelData(String filelocation,String crendentils ) throws IOException{
		String[][] Data =null;
		try {
			FileInputStream IpS= new FileInputStream(filelocation);
			XSSFWorkbook wb = new XSSFWorkbook(IpS);
			XSSFSheet importsheet = wb.getSheet(crendentils);
			int totalRow = importsheet.getLastRowNum()+1;
			int totalcells =importsheet.getRow(0).getLastCellNum();
			Data = new String[totalRow-1][totalcells];
			
			for(int currentRow=1;currentRow < totalRow;currentRow++)
            {
			for(int currentcell=0;currentcell < totalcells;currentcell++) 
			{
				Data[currentRow-1][currentcell]= importsheet.getRow(currentRow).getCell(currentcell).getStringCellValue();
				wb.close();	
					
					
			}
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Data;
		
		
	}
	
	
}
