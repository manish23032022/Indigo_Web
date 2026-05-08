package CA42_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class CA42_EventGrading_page {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public CA42_EventGrading_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.webUtil = new WebDriverUtility();
	    }
	    
	   // @FindBy(xpath = "//button[@id='Discard_yes']")
	   // private WebElement acceptYesPopup;
	    

	    @FindBy(xpath = "//label[contains(.,'Certified')]/following-sibling::button[text()='YES']")
	    private WebElement acceptYesPopup;
       

	    @FindBy(xpath = "//h2[contains(text(),'Nature of Duty')]/descendant::input[@id='pm']")
	    private WebElement pmButton;


	    @FindBy(xpath = "//input[@id='RegNo']")
	    private WebElement registrationInputField;
	    

	    @FindBy(xpath = "//select[@id='typeOfCheck']")
	    private WebElement typeOfCheckDrop;
	    
	    @FindBy(xpath = "//select[@id='typeOfapproach']")
	    private WebElement typeOfApproachDrop;
	    

	    @FindBy(xpath = "//select[@id='crewstatus']")
	    private WebElement crewStatusDrop;
	   

	    @FindBy(xpath = "//h2[contains(text(),'TAKE OFF DAY/NIGHT:')]/parent::div/following-sibling::div//label[@for='DAY']")
	    private WebElement takeOffDayBtn;

	    @FindBy(xpath = "//h2[contains(text(),'LANDING DAY/NIGHT')]/parent::div/following-sibling::div//label[@for='NIGHT2']")
	    private WebElement landingNightBtn;

	    @FindBy(xpath = "//select[@id='SEATOCCUPIED']")
	    private WebElement seatOccupiedDrop;
	    
	    @FindBy(xpath = "//select[@id='type']")
	    private WebElement airoplaneDrop;
	   
	    @FindBy(xpath = "//button[@id='eventGrading' and contains(.,'Next')]")
	    private WebElement saveAndNextBtn;

	    /** Search and click HPFD Grade Button  
	     * @throws InterruptedException */
	    public void enterGradingDetails(String regNum) throws InterruptedException {
	    	webUtil.sleep(2000);
	    	webUtil.safeClick(driver, acceptYesPopup);
	    	System.out.println("sucessfully click on yes popup");
	    	webUtil.sleep(2000);
	        webUtil.safeClick(driver,pmButton);
	        webUtil.sleep(2000);
	        webUtil.safeType(driver, registrationInputField, regNum);
	        webUtil.selectByIndex(typeOfCheckDrop, 1);
	        webUtil.selectByIndex(typeOfApproachDrop, 2);
	        webUtil.selectByIndex(crewStatusDrop, 2);
	        webUtil.safeClick(driver, takeOffDayBtn);
	        webUtil.safeClick(driver, landingNightBtn);
	        webUtil.selectByIndex(airoplaneDrop, 1);
	        webUtil.selectByIndex(seatOccupiedDrop, 1);
	        webUtil.selectByIndex(crewStatusDrop, 2);
	        webUtil.safeClick(driver, saveAndNextBtn);
	        Thread.sleep(3000);
	        
	        
	    }
	    
	    

}
