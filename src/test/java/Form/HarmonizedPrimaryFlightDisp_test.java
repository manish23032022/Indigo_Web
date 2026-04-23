package Form;

import org.testng.annotations.Test;

import Base.BaseClass;
import Common_Pom.BecomeUserPage;
import Common_Pom.TraineeReviewPage;
import Common_Pom.TrainingManagerReviewPage;
import HarmonizedPrimaryFlightDisp_POM.EventGrading_page;
import Common_Pom.GradingAssesementMod_page;
import HarmonizedPrimaryFlightDisp_POM.OverallOutcome_page;

public class HarmonizedPrimaryFlightDisp_test extends BaseClass {
	
	//Stand alone event HPFD

		@Test(priority = 1,
	    groups = {"smokeTest"},
		description = "Trainer submits StandaloneHPFD Form E2E Happy Path")
				
		public void end2endTrainerSubmitEventForTrainee() throws Throwable {
        String trainerId = fileUtil.getDataFromPropertiesFile("becomeHPFDTrainerId");
        String lessonName=fileUtil.getDataFromPropertiesFile("lessonHPFDEvent");
        String regNum=fileUtil.getDataFromPropertiesFile("registrationNumber");
        BecomeUserPage becomeUser=new BecomeUserPage(driver);
        becomeUser.becomeUser_method(trainerId);
        System.out.println("===Sucessfully search Trainer to perform HPFD by Become User Field==="+ trainerId);
        
        GradingAssesementMod_page gradingAssesementBtn=new GradingAssesementMod_page(driver);
        gradingAssesementBtn.clickOnGradingSubMod();
        gradingAssesementBtn.searchAndClickGradeBtn(lessonName);
        System.out.println("===Sucessfully click on main Grade Btn in Event HomePage ===");
        
        EventGrading_page grading=new EventGrading_page(driver);
        grading.enterRegAndselectAircraftType(regNum);
        grading.clickSaveAndNextBtn();
        System.out.println("===Sucessfully perform Grading Page ===");
        
        OverallOutcome_page overallOutcomePage = new OverallOutcome_page(driver);
       // overallOutcomePage.gradeAllCompetenciesWithFour();
        overallOutcomePage.fpm4Grade();
        overallOutcomePage.kno4Grade();
        overallOutcomePage.overallcommentToPrievewOkBtn();
        overallOutcomePage.digitalSign();
        overallOutcomePage.clickSaveSignitureButtonForDigitalSigniture();
        overallOutcomePage.clickPopUpOkButton();
        System.out.println("Successfully selected grade 4 for all competencies and handled popup.");
        
       
    }
		
		@Test( priority = 2, 
		        groups = {"smokeTest"},
		        description = "Trainee accepts 'Acknowledgement' after trainer submission"	)	
		
				public void end2endTraineeAcceptAcknowledgement() throws Throwable {
		        String traineeId = fileUtil.getDataFromPropertiesFile("hPFDtraineeId");
		        BecomeUserPage becomeUser=new BecomeUserPage(driver);
		        becomeUser.becomeUser_method(traineeId);
		        
		        String lessonName=fileUtil.getDataFromPropertiesFile("lessonHPFDEvent");
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
				String traineeId = fileUtil.getDataFromPropertiesFile("hPFDtraineeId");
				tmr.searchForTraineeUnderTMR(traineeId);
				tmr.toPerformAdminApprove();
		        System.out.println("sucessfully to perform Approve from Admin by TMR");
		       
		        
		}
		        
		
}