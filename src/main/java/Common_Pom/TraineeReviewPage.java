package Common_Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.WebDriverUtility;

public class TraineeReviewPage {
	 	private WebDriver driver;
	    private WebDriverUtility webUtil;
	    private WebDriverWait wait;

	    public TraineeReviewPage(WebDriver driver) {
	        this.driver = driver;
	        this.webUtil = new WebDriverUtility();
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//span[normalize-space(text())='Grading & Assessment']")
		private WebElement gradingAndAssessmentMod;

		@FindBy(xpath = "//span[normalize-space(text())='Trainee Review']")
		private WebElement traineeReviewSubMod;

		@FindBy(xpath = "//input[@class=' form-control search_field']")
		private WebElement searchField;

		@FindBy(xpath = "//button[@id='viewClick']")
		private WebElement viewButtons;
		
		@FindBy(xpath = "//button[@id='Acknowledgebtn']")
		private WebElement acknowledgeButton;
		

		@FindBy(xpath = "//button[@id=\"ebtack_login_btn\"]")
		private WebElement traineeAcknowldgementSubmitButton;
		
		@FindBy(xpath = "//canvas[@id='signature-pad']")
		private WebElement digitalSignitureTextAreaField;
		
		@FindBy(xpath = "//button[@id='save-button']")
		private WebElement digitalSignitureSaveSignitureButton;



		@FindBy(xpath = "//span[contains(text(),'OK')]")
		private WebElement popupDataSuccessfullyUploadedOkButton;

		 public void toPerformAcknowledgement(String lessonName) {
		        webUtil.safeClick(driver, gradingAndAssessmentMod);
		        webUtil.safeClick(driver, traineeReviewSubMod);
		        webUtil.safeType(driver, searchField, lessonName);
		        webUtil.safeClick(driver, viewButtons);
		        webUtil.safeClick(driver, acknowledgeButton);
		        webUtil.safeClick(driver, traineeAcknowldgementSubmitButton);
		        
		    }
		 public void digitalSign() {
				webUtil.safeClick(driver, digitalSignitureTextAreaField);
				Actions drawAction = new Actions(driver);
				drawAction.moveToElement(digitalSignitureTextAreaField, 50, 60).clickAndHold().moveByOffset(30, 20)
						.moveByOffset(30, -40).moveByOffset(30, 40).moveByOffset(50, 0).release().build().perform();
			}
		 
		 public void clickSaveSignitureButtonForDigitalSigniture() {
				webUtil.safeClick(driver, digitalSignitureSaveSignitureButton);
			}
		 
		 public void clickPopUpOkButton() {
				webUtil.safeClick(driver, popupDataSuccessfullyUploadedOkButton);
			}

		
}
