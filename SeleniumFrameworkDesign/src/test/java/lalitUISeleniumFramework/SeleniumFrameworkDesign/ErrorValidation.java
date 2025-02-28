package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ErrorValidation extends baseTest {
 
	@Test
	public  void submitOrder() throws InterruptedException {
		// TODO Auto-generated method stub	     
			     LoginPage.loginApplication("lalitsingh@gmail.com", "Lalit@gmail12");
				 Assert.assertEquals("Incorrect email or password.",LoginPage.getErrorMessage());

	}

}
