package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	public class CorrectUserName {
		@Test
		@Parameters({"username","password"})
	           public void logInCorrectName(String uname,String pword)
	           {
	        	   System.setProperty("webdriver.chrome.driver", "C://Users//admin//Downloads//chromedriver_win32 (1)//chromedriver.exe");
	               WebDriver driver= new ChromeDriver();
	               driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	               WebElement username=driver.findElement(By.id("txtUsername"));
	               username.sendKeys(uname);
	               WebElement password = driver.findElement(By.id("txtPassword"));
	               password.sendKeys(pword);
	               WebElement login=driver.findElement(By.id("btnLogin"));
	               login.click();
	               driver.quit();
	           }
}
}
