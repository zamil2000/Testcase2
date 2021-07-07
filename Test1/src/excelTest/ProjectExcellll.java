package excelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ProjectExcellll {
		String[][] data ;
		 WebDriver driver;
		@DataProvider(name="log")
		public String[][] loginData() throws BiffException, IOException
		{
			data=getexcel();
			return data;	
		}
    public String[][] getexcel() throws BiffException, IOException
    {
    	FileInputStream file= new FileInputStream("C:\\Users\\admin\\Desktop\\proj.xls");
    Workbook work= Workbook.getWorkbook(file);
      Sheet sheet= work.getSheet(0);
      int countrow=sheet.getRows();
      int countcoloumn=sheet.getColumns();
      String[][] testdata= new String[countrow-1][countcoloumn];
      for(int i=1;i<countrow;i++)
      {
    	  for(int j=0;j<countcoloumn;j++)
    	  {
    		  testdata[i-1][j]= sheet.getCell(j, i).getContents();
    	  }
      }
      return testdata;
    }
    @BeforeTest
    public void start()
    {
    	 System.setProperty("webdriver.chrome.driver", "C://Users//admin//Downloads//chromedriver_win32 (1)//chromedriver.exe");
          driver= new ChromeDriver();
    }
    @AfterTest
    public void after()
    {
    	driver.quit();	
    }
      @Test(dataProvider = "log")
      public void logInCorrect(String uname,String pword)
      {
          driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
         
          WebElement username=driver.findElement(By.id("txtUsername"));
          username.sendKeys(uname);
          
          WebElement password = driver.findElement(By.id("txtPassword"));
          password.sendKeys(pword);
          
          WebElement login=driver.findElement(By.id("btnLogin"));
          login.click();
          
      
    }

}

