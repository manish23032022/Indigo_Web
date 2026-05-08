package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Common_Pom.BecomeUserPage;
import Common_Pom.HomePage;
import Common_Pom.LoginPage;
import Utility.FileUtility;
import Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public FileUtility fileUtil = new FileUtility();
    public WebDriverUtility webUtil = new WebDriverUtility();
    public WebDriver driver;                   //used to Main test execution
    public static WebDriver sdriver;           //used to Used in listeners/screenshot

    public LoginPage login;
   // public BecomeUserPage becomeUser;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Throwable {

        String browser = System.getProperty("browser", fileUtil.getDataFromPropertiesFile("browser"));

        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions());
            
            /**  these method for run Headless mode means without UI
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");          // run in headless mode
            options.addArguments("--disable-gpu");       // recommended
            options.addArguments("--window-size=1920,1080"); // avoid UI issues

            driver = new ChromeDriver(options);
            **/

            System.out.println("Launching Chrome browser");
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(new FirefoxOptions());
            System.out.println("Launching Firefox browser");
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(new EdgeOptions());
            System.out.println("Launching Edge browser");
        } 
        else {
            System.out.println("Invalid browser: " + browser + ". Launching Chrome by default.");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions());
        }

        driver.manage().window().maximize();
        webUtil.waitForPageToLoad(driver);

        sdriver = driver;
        System.out.println("=== Browser launched successfully ===");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Throwable {

        if (driver == null) {
            throw new IllegalStateException("Driver is null. Check @BeforeClass execution and TestNG annotations.");
        }

        String url = System.getProperty("url", fileUtil.getDataFromPropertiesFile("url"));
        String username = System.getProperty("username", fileUtil.getDataFromPropertiesFile("username"));
        String password = System.getProperty("password", fileUtil.getDataFromPropertiesFile("password"));

        driver.get(url);

        login = new LoginPage(driver);
        login.loginToapp(url, username, password);
        System.out.println("=== Login successful ===");

//        becomeUser = new BecomeUserPage(driver);
//        System.out.println("=== Search Trainer Sucessful by BecomeUser ===");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        try {
            if (driver != null) {
                new HomePage(driver).logout();
                System.out.println("=== Logout successful ===");
            }
        } catch (Exception e) {
            System.out.println("Logout skipped or already logged out.");
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("=== Browser closed ===");
            } catch (Exception e) {
                System.out.println("Error closing browser: " + e.getMessage());
            }
        }
    }
}