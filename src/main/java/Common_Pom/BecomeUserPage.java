package Common_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class BecomeUserPage {

    private WebDriver driver;
    private WebDriverUtility webUtil;

    public BecomeUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.webUtil = new WebDriverUtility();
    }

    @FindBy(xpath = "//li[@id='superUser_menu']//span[contains(text(),'Become')]")
    private WebElement becomeUserModule;

    @FindBy(id = "usernameField")
    private WebElement userInput;

    @FindBy(xpath = "//button[@id='update']")
    private WebElement btnBecomeUser;

    public void becomeUser_method(String userId) {
        webUtil.safeClick(driver, becomeUserModule);
        webUtil.safeType(driver, userInput, userId);
        webUtil.safeClick(driver, btnBecomeUser);
        webUtil.sleep(2000);
    }
}