package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
    
    public WebDriver driver;
    public loginPage LoginPage;
 
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream( System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
        prop.load(fs);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) 
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        else if (browserName.equalsIgnoreCase("fireFox")) 
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    
   @BeforeMethod 
    public loginPage launchApplication() throws IOException {
        driver = initializeDriver();
        LoginPage = new loginPage(driver);
        LoginPage.goTo();
        return LoginPage;
    }
   
   @AfterMethod
   public void tearDown() {
	   driver.close();
   }
}
