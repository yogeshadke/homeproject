package Demo5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parentclass_login 
{
	WebDriver driver;
	
public static void plo()
{
	WebDriver driver;
	driver =new ChromeDriver();
	driver.get("http://facebook.com");
	
	
	
}


public class childd extends Parentclass_login
{
	@Test
	public void main(String arg[]) 
	{
		
		System.out.println("test");
	   //super.plo;
		
		
	}
	
	
}
}