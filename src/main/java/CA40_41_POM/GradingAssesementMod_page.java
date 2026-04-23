package CA40_41_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class GradingAssesementMod_page {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public GradingAssesementMod_page(WebDriver driver) {
	        this.driver = driver;
	        this.webUtil = new WebDriverUtility();
	        PageFactory.initElements(driver, this);
	    }
	    
	    /** -------------------- Logout Elements -------------------- */
	    @FindBy(xpath = "//span[text()='Grading & Assessment']")
	    private WebElement gradingAssesentBtn;

	    @FindBy(xpath = "//li[@id='Grading_menu']/a/span[contains(text(),'Grading')]")
	    private WebElement gradingSubBtn;
	    
	    @FindBy(xpath = "//div[@id='AimsDatatable_filter']/div/input[@type='search']")
	    private WebElement searchField;
	    

	    @FindBy(xpath = "(//img[contains(@src,'Grade_2')])[1]")
	    private WebElement gradeBtn;
	    
	    @FindBy(xpath = "//button[text()='Grade']")
	    private WebElement insideGradeBtn;
	    
	    
	    
	    /** -------------------- Business Methods -------------------- */

	    /** Logout from the application */
	    public void clickOnGradingSubMod() {
	        webUtil.safeClick(driver, gradingAssesentBtn);
	        webUtil.safeClick(driver, gradingSubBtn);
	    }
	    
	    /** Search and click HPFD Grade Button  */
	    public void searchAndClickGradeBtn(String lessonName) {
	        webUtil.safeType(driver, searchField, lessonName);
	        webUtil.safeClick(driver, gradeBtn);
	        clickInsideGradeIfPresent();
	    }
	    
	    private boolean isElementClickable(WebElement element) {
	        try {
	            webUtil.waitForElementClickable(driver, element);
	            return element.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    
	    public void clickInsideGradeIfPresent() {
	        if (isElementClickable(insideGradeBtn)) {
	            webUtil.safeClick(driver, insideGradeBtn);
	            System.out.println("=== Clicked Inside Grade Button ===");
	        } else {
	            System.out.println("=== Already inside grading page OR button not visible ===");
	        }
	    }

}
