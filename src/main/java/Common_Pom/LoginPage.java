package Common_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;
/**
 * 
 * @author Manish
 * 
 * Contains Login page elements & business lib like login()
 *
 */  

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	 public LoginPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	                           
	@FindBy(xpath="//input[@id='textbox1']")                        // Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(xpath="//input[@id='textbox2']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	     
	
	
	
	public WebElement getUsernameEdt() {            //Rule-4 : Object Encapsulation
		return usernameEdt;                        //Rule-5 : Object Utilization
	}
	
	public void setUsernameEdt(WebElement username) {
		this.usernameEdt = username;
		}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
	public void setPasswordEdt(WebElement password) {
		this.passwordEdt = password;
		}
	

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
	
/**
*  login to application based username , password , url argumnets 
* @param url
* @param username
* @param password
*/
	 public void loginToapp(String url , String username , String password) {
		 waitForPageToLoad(driver);
		 driver.get(url);	
		 usernameEdt.sendKeys(username);
		 passwordEdt.sendKeys(password);
		 loginBtn.click();
	 }
	
	

}
