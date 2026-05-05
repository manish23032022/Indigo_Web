package CA40_41_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class outcomeMod_page {

    private WebDriver driver;
    private WebDriverUtility webUtil;

    public outcomeMod_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.webUtil = new WebDriverUtility();
    }

    @FindBy(xpath = "//span[text()='EVALUATION PHASE']")
    private WebElement evaluationPhasePlusBtn;
    

    @FindBy(xpath = "//span[text()='MANEUVER PHASE']")
    private WebElement maneuverPlusBtn;
    
    

    @FindBy(xpath = "//table[@id='overall_COM_GRD_LHS']//td[@data-grade-val='4']")
    private List<WebElement> gradeFourCellsforEvaluationPhase;
    

    @FindBy(xpath = "//table[@id='MANoverall_COM_GRD_LHS']//td[@data-grade-val='4']")
    private List<WebElement> gradeFourCellsforManeuverPhase;

    private By activeModalLocator = By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]");
    private By plusBtnLocator = By.xpath(".//button[contains(@class,'fa-plus')]");
    private By commentAreaLocator = By.xpath(".//textarea[contains(@class,'comment-textarea')]");
    private By doneBtnLocator = By.xpath(".//button[contains(text(),'DONE')]");

    public void performEvaluationPhase() {

        webUtil.safeClick(driver, evaluationPhasePlusBtn);

        for (WebElement cell : gradeFourCellsforEvaluationPhase) {

            webUtil.safeClick(driver, cell);
            webUtil.sleep(1000);

            WebElement activeModal = driver.findElement(activeModalLocator);

            WebElement plusBtn = activeModal.findElement(plusBtnLocator);
            WebElement commentArea = activeModal.findElement(commentAreaLocator);
            WebElement doneBtn = activeModal.findElement(doneBtnLocator);

            webUtil.safeClick(driver, plusBtn);
            webUtil.sleep(1000);

            webUtil.safeType(driver, commentArea, "Evaluation phase obs comment by manish");
            webUtil.sleep(1000);

            webUtil.safeClick(driver, doneBtn);
            webUtil.sleep(1000);
        }
    }
    
    public void performManeuver() {
    	
    	webUtil.sleep(3000);

        webUtil.jsClickAndScrollUp(driver, maneuverPlusBtn);

        for (WebElement cell : gradeFourCellsforManeuverPhase) {

            webUtil.safeClick(driver, cell);
            webUtil.sleep(1000);

            WebElement activeModal = driver.findElement(activeModalLocator);

            WebElement plusBtn = activeModal.findElement(plusBtnLocator);
            WebElement commentArea = activeModal.findElement(commentAreaLocator);
            WebElement doneBtn = activeModal.findElement(doneBtnLocator);

            webUtil.safeClick(driver, plusBtn);
            webUtil.sleep(1000);

            webUtil.safeType(driver, commentArea, "Maneuver phase obs comment by manish");
            webUtil.sleep(1000);

            webUtil.safeClick(driver, doneBtn);
            webUtil.sleep(1000);
        }
    }

    @FindBy(xpath = "//label[text()='REMARKS']")
    private WebElement remarkText;
    
    @FindBy(xpath = "//textarea[@id='overallcomment_textarea_LHS']")
    private WebElement overallOutcomeComment;
    
    @FindBy(xpath = "//select[@id='TRIDE']")
    private WebElement selectQualification;
    

    @FindBy(xpath = "//button[text()='Save and next']")
    private WebElement saveAndNextBtn;
    

    @FindBy(xpath = "//textarea[@id='comment_textarea']")
    private WebElement commentforDelayGradingPopup;
    


    @FindBy(xpath = "//button[@id='saveComment']")
    private WebElement submitCommentBtn;
    

    @FindBy(xpath = "//button[@id='previewNext' and contains(.,'Next')]")
    private WebElement previewNextBtn;
    

    @FindBy(xpath = "//button[@id='ebtack_login_btn' and contains(.,'Submit')]")
    private WebElement InstructorAcknSubmitBtn;
    
    @FindBy(xpath = "//canvas[@id='signature-pad']")
	private WebElement digitalSignitureTextAreaField;
	
	@FindBy(xpath = "//button[@id='save-button']")
	private WebElement digitalSignitureSaveSignitureButton;



	@FindBy(xpath = "//span[contains(text(),'OK')]")
	private WebElement popupDataSuccessfullyUploadedOkButton;


    
    
    public void overallcommentToPrievewOkBtn() throws InterruptedException {
    	 webUtil.sleep(1000);
    	webUtil.scrollUpToElement(driver, remarkText);
    	 webUtil.sleep(2000);
        webUtil.safeType(driver, overallOutcomeComment, "manishOverallComment");
        Thread.sleep(1500);
        webUtil.selectByIndex(selectQualification, 1);
        webUtil.safeClick(driver, saveAndNextBtn);
        Thread.sleep(1500);
        webUtil.safeType(driver, commentforDelayGradingPopup, "manishCommentforDelay");
        Thread.sleep(1500);
        webUtil.safeClick(driver, submitCommentBtn);
        Thread.sleep(5000);
        webUtil.safeClick(driver, previewNextBtn);
        Thread.sleep(1500);
        webUtil.safeClick(driver, InstructorAcknSubmitBtn);
    }
        
    public void digitalSign() throws InterruptedException {
		webUtil.safeClick(driver, digitalSignitureTextAreaField);
		Actions drawAction = new Actions(driver);
		//drawAction.moveToElement(digitalSignitureTextAreaField, 50, 60).clickAndHold().moveByOffset(30, 20)
				//.moveByOffset(30, -40).moveByOffset(30, 40).moveByOffset(50, 0).release().build().perform();
		drawAction
	    .moveToElement(digitalSignitureTextAreaField, 10, 80) // start bottom-left
	    .clickAndHold()
	    .moveByOffset(0, -60).moveByOffset(20, 60).moveByOffset(20, -60).moveByOffset(0, 90).release().build().perform();
		Thread.sleep(3000);
	}
 
    public void clickSaveSignitureButtonForDigitalSigniture() {
		webUtil.safeClick(driver, digitalSignitureSaveSignitureButton);
	}
 
    public void clickPopUpOkButton() {
		webUtil.safeClick(driver, popupDataSuccessfullyUploadedOkButton);
	} 
}