package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class submitClass extends baseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String elementSearch="ZARA COAT 3";
	     ProductCatalogue productCatalogue= LoginPage.loginApplication("lalitsingh@gmail.com", "Lalit@gmail1");
		 
	     List<WebElement>products=productCatalogue.getProductList();
	     productCatalogue.addProductToCart(elementSearch);
	     CartItem cartItem = productCatalogue.goToCartPage();
		 
		Boolean value = cartItem.cartList(elementSearch);
		Assert.assertTrue(value);
		System.out.println(value);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		
		CheckoutPage checkoutPage =cartItem.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	public String getScreenShot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

}
