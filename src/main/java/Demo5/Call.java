package Demo5;

import java.util.Scanner;

import org.testng.annotations.*;

public class Call {
	
	@SuppressWarnings("null")
	@DataProvider (name= "pass")
	public Object[][] acessdata()
	{
	
	return new Object[][] {{"ram"},{"sita"},{"laxmi"},{"barat"},{"hanuman"},{"ravan"},{"lanka"},{"lav"},{"kush"}};
	
	}
	@Test (dataProvider="pass")
	public void fromacess(String valuve) 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input");
		String Sng = sc.next();
		//char cr = sc.next().charAt(0);
	   if(Sng.equals(valuve)){
		  System.out.println("user present in data base"); 
		   
	   } 
	   else
	   {
		   System.out.println("user not present in data base");
	   }
		
	}

}
