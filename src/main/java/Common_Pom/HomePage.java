package Common_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;


public class HomePage {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        this.webUtil = new WebDriverUtility();
	        PageFactory.initElements(driver, this);
	    }
	    
	    /** -------------------- Logout Elements -------------------- */
	    @FindBy(xpath = "//span[@class='avatar avatar-online']")
	    private WebElement imgLogout;

	    @FindBy(xpath = "//li[@role='presentation' and contains(.,' Logout')]")
	    private WebElement logoutBtn;
	    
	    /** -------------------- Business Methods -------------------- */

	    /** Logout from the application */
	    public void logout() {
	        webUtil.safeClick(driver, imgLogout);
	        webUtil.safeClick(driver, logoutBtn);
	    }

}
