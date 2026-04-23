package Common_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class TrainingManagerReviewPage {
	
	  private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public TrainingManagerReviewPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.webUtil = new WebDriverUtility();
	    }
	    @FindBy(xpath = "//span[@class='site-menu-title' and normalize-space(text())='Grading & Assessment']")
	    private WebElement gradingAndAssessmentMod;
	 
	    @FindBy(xpath = "//span[@class='site-menu-title' and normalize-space(text())='Training Manager Review']")
	    private WebElement trainingManagerReviewSubMod;
	    

	    @FindBy(xpath = "//input[contains(@class,'search_field')]")
	    private WebElement searchTextField;
	    
	    @FindBy(xpath = "//button[normalize-space()='View']")
	    private WebElement viewButton; 
	    

	    @FindBy(id = "commentsmodal")
	    private WebElement commentTextAreaField;
	    

	    @FindBy(id = "approveBtn")
	    private WebElement approveButton;
	    
	    @FindBy(id = "home_button_yes")
	    private WebElement yesButtonForApprovePopup;

	    @FindBy(xpath = "//span[text()='OK']")
	    private WebElement popUpOkButton;

	    public void searchForTraineeUnderTMR(String traineeId) throws InterruptedException {
	    	webUtil.safeClick(driver, gradingAndAssessmentMod);
	    	webUtil.safeClick(driver, trainingManagerReviewSubMod);
	    	// Thread.sleep(100000);
	    	 webUtil.sleep(150000);
	    	webUtil.safeType(driver, searchTextField, traineeId);
	       
	    }
	    
	    public void toPerformAdminApprove() throws InterruptedException {
	    	webUtil.safeClick(driver, viewButton);
	        webUtil.safeType(driver, commentTextAreaField,"manishCommentForTesting");
	        webUtil.safeClick(driver, approveButton);
	        webUtil.safeClick(driver, yesButtonForApprovePopup);
	        webUtil.safeClick(driver, popUpOkButton);
	    }
	    



}
