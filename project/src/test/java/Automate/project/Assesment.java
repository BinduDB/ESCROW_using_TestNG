package Automate.project;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Assesment 
{
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	
	}
   	@BeforeClass
   	public void EnterApplication()
   	{
   		
    	driver.get("https://www.amazon.in/");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	}	
    	
   	
   	
   	@Test
   	public void TestExecution() throws Exception
   	{
   		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watches");
    	driver.findElement(By.id("nav-search-submit-button")).click();
    	
    	WebElement leather=	driver.findElement(By.xpath("//span[text()='Leather']"));
		leather.click();
		
		WebElement Fast=driver.findElement(By.linkText("Fastrack"));
		Fast.click();
		
		WebElement Img=driver.findElement(By.linkText("Mens Analog White Dial Brown Band Leather Watch"));
		Img.click();
	
		
		
		Set<String> s=driver.getWindowHandles();
		ArrayList ar=new ArrayList(s);
		
		
		driver.switchTo().window((String)ar.get(1));
			
		WebElement Add=driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
		Add.click();
		//driver.findElement(By.xpath("(//input[@class=\"a-button-input\"])[18]"));
		
		
		driver.findElement(By.xpath("//span[@id=\"attachSiNoCoverage\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();
			
   	}	
    }

