package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.TopMenuPage;

import static com.codeborne.selenide.Selenide.*;


public class CorrectLoginTests {
    @BeforeClass
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @BeforeMethod
    public void beforeTest() {
        Configuration.browser = "edge";
    }

    @Test
    @Description("Test poprawnego logowania")
    @Severity(SeverityLevel.BLOCKER)
    public void correctLoginTest() {
        open("https://www.morele.net/");
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .clickOnLoginButton()
                .typeEmailIntoUserEmailField("otua.tamotua@op.pl")
                .typePasswordIntoPasswordField("TestyME123$")
                .clikOnLoginButton()
                .assertThatLoginButtonChangeNameAfterCorrectLogin("Witaj");
    }

    @Test
    public void correctLoginAndLogoutTest() {
        correctLoginTest();
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage
                .moveToWelcomeButton()
                .clickLogoutButton()
                .asssertThatLoginButtonAfterCorrectLogoutIsChanged();

    }

}
