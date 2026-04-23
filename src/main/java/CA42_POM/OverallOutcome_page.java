package CA42_POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    
    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-plus') and @data-item-id-code='FPMa']")
    private WebElement plusOb;
    
  
    @FindBy(xpath = "//div[@class='modal fade in']//descendant::button[contains(@class,'fa-minus') and @data-item-id-code='FPMb']")
    private WebElement minusOb;
    

    @FindBy(xpath = "//div[@id='FPM_charCountDisplay']/parent::div/textarea[@id='FPM_competency_comment_txtarea']")
    private WebElement ob_comment;
    

    @FindBy(xpath = "//button[@data-ri_item-code='KNO4' and contains(.,'DONE')]")
    private WebElement obDoneBtn;
    
    
    public void gradeAllCompetenciesWithFour() {
      wait.until(ExpectedConditions.visibilityOfAllElements(allGradeRows));

      for (WebElement grade:allGradeRows) {
      	
          WebElement gradeFourCell = grade.findElement(By.xpath(".//td[@data-grade-val='4']"));
          webUtil.safeClick(driver, gradeFourCell);
              
         webUtil.safeClick(driver, plusOb);
         webUtil.safeClick(driver, minusOb);
         webUtil.safeType(driver, ob_comment, "obs comment by manish");
         
          
              webUtil.safeClick(driver, obDoneBtn);
            }
  }
    
}
