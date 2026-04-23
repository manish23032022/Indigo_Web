package HarmonizedPrimaryFlightDisp_POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.WebDriverUtility;

public class OverallOutcome_page {

    private WebDriver driver;
    private WebDriverUtility webUtil;
    private WebDriverWait wait;

    public OverallOutcome_page(WebDriver driver) {
        this.driver = driver;
        this.webUtil = new WebDriverUtility();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='overall_COM_GRD_LHS']//tbody/tr")
    private List<WebElement> allGradeRows;
    


    @FindBy(xpath = "//td[@id='LHS_FPM_3']")
    private WebElement fpmGrade4;
    

    

    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-plus') and @data-item-id-code='FPMa']")
    private WebElement fpmPlusOb;
    
  
    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-minus') and @data-item-id-code='FPMb']")
    private WebElement fpmMinusOb;
    
    @FindBy(xpath = "//td[@id='LHS_KNO_3']")
    private WebElement knoGrade4;
    

    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-plus') and @data-item-id-code='KNOa']")
    private WebElement knoPlusOb;
    
  
    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-minus') and @data-item-id-code='KNOb']")
    private WebElement knoMinusOb;
    

    

    
    @FindBy(xpath = "//div[@id='FPM_charCountDisplay']/parent::div/textarea[@id='FPM_competency_comment_txtarea']")
    private WebElement fpm_ob_comment;
    

    @FindBy(xpath = "//div[@id='KNO_charCountDisplay']/parent::div/textarea[@id='KNO_competency_comment_txtarea']")
    private WebElement kno_ob_comment;
    

    @FindBy(xpath = "//button[@data-ri_item-code='FPM4' and contains(.,'DONE')]")
    private WebElement fpmObDoneBtn;
    

    @FindBy(xpath = "//button[@data-ri_item-code='KNO4' and contains(.,'DONE')]")
    private WebElement knoObDoneBtn;
    
    /**
    ////button[@data-task-type="overall" and contains(.,'DONE')]
    ///
    //.//button[contains(text(),'DONE')]
    ///
     */
    
    
    @FindBy(xpath = "//textarea[@id='overallcomment_textarea_LHS1']")
    private WebElement overallOutcomeComment;
    
    @FindBy(xpath = "//select[@id='TRIDE']")
    private WebElement selectQualification;
    

    @FindBy(xpath = "//button[@id='overallOC_next']")
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


  
    
    public void fpm4Grade() throws InterruptedException {
    	webUtil.safeClick(driver, fpmGrade4);
    	try {
    	    webUtil.safeClick(driver, fpmGrade4);
    	} catch (Exception e) {
    	    System.out.println("Already clicked on 4 button");
    	}
    	Thread.sleep(3000);
    	webUtil.safeClick(driver, fpmPlusOb);
    	Thread.sleep(3000);
    	webUtil.safeClick(driver, fpmMinusOb);
    	webUtil.sleep(3000);
    	webUtil.safeType(driver, fpm_ob_comment, "fPM comment sucessfull");
    	webUtil.sleep(3000);
    	webUtil.safeClick(driver, fpmObDoneBtn);
    }
    
    public void kno4Grade() throws InterruptedException {
    	webUtil.safeClick(driver, knoGrade4);
    	Thread.sleep(3000);
    	webUtil.safeClick(driver, knoPlusOb);
    	Thread.sleep(3000);
    	webUtil.safeClick(driver, knoMinusOb);
    	webUtil.sleep(3000);
    	webUtil.safeType(driver, kno_ob_comment, "KNO comment sucessfull");
    	webUtil.sleep(3000);
    	webUtil.safeClick(driver, knoObDoneBtn);
    }
    

    


//    public void gradeAllCompetenciesWithFour() {
//        wait.until(ExpectedConditions.visibilityOfAllElements(allGradeRows));
//
//        for (WebElement grade:allGradeRows) {
//        	
//            WebElement gradeFourCell = grade.findElement(By.xpath(".//td[@data-grade-val='4']"));
//            webUtil.safeClick(driver, gradeFourCell);
//                
//           webUtil.safeClick(driver, plusOb);
//           webUtil.safeClick(driver, minusOb);
//           webUtil.safeType(driver, ob_comment, "obs comment by manish");
//           webUtil.sleep(5000);
//            
//                webUtil.safeClick(driver, obDoneBtn);
//              }
//    }
        
    public void overallcommentToPrievewOkBtn() throws InterruptedException {
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