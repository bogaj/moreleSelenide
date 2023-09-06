package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

public class IncorrectLoginTests extends TestBase {

    @Test
    @Description("Logowanie się za pomocą niepoprawnego adresu e-mail - bez @")
    public void loginUsingIncorrectEmailTest() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnLoginButtonInTopMenu()
                .typeEmailIntoUserEmailField("otua.tamotua")
                .typePasswordIntoPasswordField("TestyME123$")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.assertThatIncorrectEmailNotificationIsDisplayedAndIsCorrect();

    }

    @Test
    @Description("Logowanie się za pomocą niepoprawnych danych")
    public void loginUsingIncorrectDataTest(){
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnLoginButtonInTopMenu()
                .typeEmailIntoUserEmailField("ffe221@wp.pl")
                .typePasswordIntoPasswordField("tessty1234")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.assertThatIncorrectDataPopupIsDisplayedAndIsCorrect();
    }
}
