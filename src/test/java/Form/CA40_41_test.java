package Form;

import org.testng.annotations.Test;

import Base.BaseClass;
import CA40_41_POM.CA40_41_EventGrading_page;
import CA40_41_POM.outcomeMod_page;
import Common_Pom.GradingAssesementMod_page;
import Common_Pom.TraineeReviewPage;
import Common_Pom.TrainingManagerReviewPage;
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
	        
	        CA40_41_EventGrading_page grading=new CA40_41_EventGrading_page(driver);
	        grading.enterGradingDetailsInGeneralInfo(regNum,"IR");
	        grading.enterGradeUnderTaskGrade();
	        
	        outcomeMod_page outcome=new outcomeMod_page(driver);
	        outcome.performEvaluationPhase();
	        outcome.performManeuver();
	        outcome.overallcommentToPrievewOkBtn();
	        outcome.digitalSign();
	        outcome.clickSaveSignitureButtonForDigitalSigniture();
	        outcome.clickPopUpOkButton();
	       }
	
	@Test( priority = 2, 
	        groups = {"smokeTest"},
	        description = "Trainee accepts 'Acknowledgement' after trainer submission"	)	
	
			public void end2endTraineeAcceptAcknowledgement() throws Throwable {
	        String traineeId = fileUtil.getDataFromPropertiesFile("ca40_41traineeId");
	        BecomeUserPage becomeUser=new BecomeUserPage(driver);
	        becomeUser.becomeUser_method(traineeId);
	        
	        String lessonName=fileUtil.getDataFromPropertiesFile("lessonCA40/41_Event");
	        TraineeReviewPage tr=new TraineeReviewPage(driver);
	        tr.toPerformAcknowledgement(lessonName);
	        tr.digitalSign();
	        tr.clickSaveSignitureButtonForDigitalSigniture();
	        tr.clickPopUpOkButton();
	        System.out.println("sucessfully perform Acknowledgement from Trainee Review by Trainee");
	        
	}
	
	@Test( priority = 3, 
	        groups = {"smokeTest"},
	        description = "Admin accepts 'Approve' after trainee(Acknowledgement) submission"	)	
	
			public void end2endAdminAcceptApproveAfterTraineeAcknowlegement() throws Throwable {
			TrainingManagerReviewPage tmr=new TrainingManagerReviewPage(driver);
			String traineeId = fileUtil.getDataFromPropertiesFile("ca40_41traineeId");
			tmr.searchForTraineeUnderTMR(traineeId);
			tmr.toPerformAdminApprove();
	        System.out.println("sucessfully to perform Approve from Admin by TMR");
	       
	        
	}
	        
	
	}
