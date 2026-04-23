package CA40_41_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class CA40_41_EventGrading_page {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public CA40_41_EventGrading_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.webUtil = new WebDriverUtility();
	    }
	    

	    @FindBy(xpath = "//h2[contains(text(),'Nature of Duty')]/descendant::input[@id='pm']")
	    private WebElement pmButton;


	    @FindBy(xpath = "//input[@id='RegNo']")
	    private WebElement registrationInputField;
	    

	    @FindBy(xpath = "//button[@data-id='TYPEOFTEST']/span[text()='Select']")
	    private WebElement typeOfCheckDrop;
	    
	    @FindBy(xpath = "//select[@id='typeOfapproach']")
	    private WebElement typeOfApproachDrop;
	    

	    @FindBy(xpath = "//select[@id='crewstatus']")
	    private WebElement crewStatusDrop;
	   

	    @FindBy(xpath = "//h2[contains(text(),'On/Take off')]/parent::div/following-sibling::div//label[@for='DAY']")
	    private WebElement takeOffDayBtn;

	    @FindBy(xpath = "//h2[contains(text(),'Off/Landing')]/parent::div/following-sibling::div//label[@for='NIGHT2']")
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
	    	
	       
	        webUtil.safeType(driver, registrationInputField, regNum);
	        System.out.println("sucessful registraion Num");
	        webUtil.selectByIndex(airoplaneDrop, 0);
	        System.out.println("sucessful Airoplane line Num");
	        Thread.sleep(3000);
	        webUtil.selectByIndex(typeOfCheckDrop, 2);
	        System.out.println("sucessful typeCheckDrop");
	        Thread.sleep(3000);
	       // webUtil.selectByIndex(typeOfApproachDrop, 2);
	        webUtil.selectByIndex(crewStatusDrop, 2);
	        Thread.sleep(3000);
	        webUtil.safeClick(driver, takeOffDayBtn);
	        Thread.sleep(3000);
	        webUtil.safeClick(driver, landingNightBtn);
	        
	        webUtil.selectByIndex(seatOccupiedDrop, 1);
	        webUtil.selectByIndex(crewStatusDrop, 2);
	        webUtil.safeClick(driver, saveAndNextBtn);
	        Thread.sleep(3000);
	        
	        
	    }
	    
	    

}
