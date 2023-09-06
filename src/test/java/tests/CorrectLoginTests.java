package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pageObjects.TopMenuPage;



public class CorrectLoginTests extends TestBase {


    @Test
    @Description("Test poprawnego logowania")
    @Severity(SeverityLevel.BLOCKER)
    public void correctLoginTest() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnLoginButtonInTopMenu()
                .typeEmailIntoUserEmailField("otua.tamotua@op.pl")
                .typePasswordIntoPasswordField("TestyME123$")
                .clickOnLoginButton()
                .assertThatLoginButtonChangeNameAfterCorrectLogin("Witaj");
    }

    @Test
    @Description("Test poprawnego logowania i wylogowania się")
    public void correctLoginAndLogoutTest() {
        correctLoginTest();
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .moveToWelcomeButton()
                .clickLogoutButton()
                .asssertThatLoginButtonAfterCorrectLogoutIsChanged();

    }

}
