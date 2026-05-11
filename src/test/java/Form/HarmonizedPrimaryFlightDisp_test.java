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

    // Stand alone event HPFD

    @Test(
        priority = 1,
        groups = {"smokeTest"},
        description = "Trainer submits StandaloneHPFD Form E2E Happy Path"
    )

    public void end2endTrainerSubmitEventForTrainee() throws Throwable {

        String trainerId = fileUtil.getDataFromPropertiesFile("becomeHPFDTrainerId");
        String lessonName = fileUtil.getDataFromPropertiesFile("lessonHPFDEvent");
        String regNum = fileUtil.getDataFromPropertiesFile("registrationNumber");

        BecomeUserPage becomeUser = new BecomeUserPage(driver);
        becomeUser.becomeUser_method(trainerId);

        System.out.println("=== Successfully searched Trainer ===");

        GradingAssesementMod_page gradingAssesementBtn = new GradingAssesementMod_page(driver);

        gradingAssesementBtn.clickOnGradingSubMod();
        gradingAssesementBtn.searchAndClickGradeBtn(lessonName);

        EventGrading_page grading = new EventGrading_page(driver);

        grading.enterRegAndselectAircraftType(regNum);
        grading.clickSaveAndNextBtn();

        OverallOutcome_page overallOutcomePage = new OverallOutcome_page(driver);

        overallOutcomePage.fpm4Grade();
        overallOutcomePage.kno4Grade();

        overallOutcomePage.overallcommentToPrievewOkBtn();

        overallOutcomePage.digitalSign();

        overallOutcomePage.clickSaveSignitureButtonForDigitalSigniture();

        overallOutcomePage.clickPopUpOkButton();

        System.out.println("Successfully selected grade 4");
    }


    @Test(
        priority = 2,
        groups = {"regressionTest"},
        description = "Trainee accepts Acknowledgement"
    )

    public void end2endTraineeAcceptAcknowledgement() throws Throwable {

        String traineeId = fileUtil.getDataFromPropertiesFile("hPFDtraineeId");

        BecomeUserPage becomeUser = new BecomeUserPage(driver);

        becomeUser.becomeUser_method(traineeId);

        String lessonName = fileUtil.getDataFromPropertiesFile("lessonHPFDEvent");

        TraineeReviewPage tr = new TraineeReviewPage(driver);

        tr.toPerformAcknowledgement(lessonName);

        tr.digitalSign();

        tr.clickSaveSignitureButtonForDigitalSigniture();

        tr.clickPopUpOkButton();

        System.out.println("Successfully performed acknowledgement");
    }


    @Test(
        priority = 3,
        groups = {"regressionTest"},
        description = "Admin Approves After Trainee Submission"
    )

    public void end2endAdminAcceptApproveAfterTraineeAcknowlegement() throws Throwable {

        TrainingManagerReviewPage tmr = new TrainingManagerReviewPage(driver);

        String traineeId = fileUtil.getDataFromPropertiesFile("hPFDtraineeId");

        tmr.searchForTraineeUnderTMR(traineeId);

        tmr.toPerformAdminApprove();

        System.out.println("Successfully performed admin approval");
    }
}