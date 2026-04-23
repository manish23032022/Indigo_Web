package Form;

import org.testng.annotations.Test;

import Base.BaseClass;
import CA40_41_POM.CA40_41_EventGrading_page;
import Common_Pom.GradingAssesementMod_page;
import Common_Pom.BecomeUserPage;

public class CA40_41_test extends BaseClass{
	
	@Test(priority = 1,
		    groups = {"smokeTest"},
			description = "Trainer submits CA42 Form E2E Happy Path")
					
			public void end2endTrainerSubmitEventForTrainee() throws Throwable {
			String trainerId = fileUtil.getDataFromPropertiesFile("becomeCA40/41_TrainerId");
	        String lessonName=fileUtil.getDataFromPropertiesFile("lessonCA40/41_Event");
	        String regNum=fileUtil.getDataFromPropertiesFile("registrationNumber");
	        
	        BecomeUserPage becomeUser=new BecomeUserPage(driver);
	        becomeUser.becomeUser_method(trainerId);
	        
	        GradingAssesementMod_page gradingAssesementBtn=new GradingAssesementMod_page(driver);
	        gradingAssesementBtn.clickOnGradingSubMod();
	        gradingAssesementBtn.searchAndClickGradeBtn(lessonName);
	        System.out.println("===Sucessfully click on main Grade Btn in Event HomePage ===");
	        
	       CA40_41_EventGrading_page grading=new CA40_41_EventGrading_page(driver);
	       grading.enterGradingDetails(regNum);
	       
	}
	}
