package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lalitUISeleniumFramework.abstractComponent.AbstractComponent;

public class loginPage extends AbstractComponent{
	 WebDriver driver;
    
	public loginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
     //WebElement element =	driver.findElement(By.id("userEmail"));//
      //below syntax is same as the above syntax
     @FindBy(id="userEmail")
     WebElement email;
     
     @FindBy(id="userPassword")
     WebElement pass;
     
     @FindBy(id="login")
      WebElement log;
     
     @FindBy(css="[class*='flyInOut']")
     WebElement errorMessage;
     
     public ProductCatalogue loginApplication(String emailId,String password) {
    	 email.sendKeys(emailId);
    	 pass.sendKeys(password);
    	 log.click();
    	 ProductCatalogue productCatalogue = new ProductCatalogue(driver);
    	 return productCatalogue;
     }
     
     public String getErrorMessage() {
    	 waitForWebElement(errorMessage);
    	 return errorMessage.getText();
     }
     
     public void goTo() {
    	 driver.get("https://rahulshettyacademy.com/client");
     }
     
     
}
