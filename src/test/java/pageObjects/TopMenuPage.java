package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TopMenuPage {

    private SelenideElement loginButton = $x("//span[contains(text(),'Zaloguj si')]");
    private SelenideElement welcomeSignButton = $x("//span[contains(text(),'Witaj')]");

    private SelenideElement logoutButton = $(".un-logout");

    @Step("Kliknięcie w przycisk do zalogowania się na górnym pasku")
    public LoginPage clickOnLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    @Step("Asercja: Przycisk logowania zmienia nazwę na {welcomeSignAfterCorrectLogin} po zalogowaniu")
    public TopMenuPage assertThatLoginButtonChangeNameAfterCorrectLogin(String welcomeSignAfterCorrectLogin) {
       welcomeSignButton.shouldHave(text(welcomeSignAfterCorrectLogin));
        return this;
    }

    @Step("Przesunięcie kursora do przycisku Witaj")
    public TopMenuPage moveToWelcomeButton() {
        welcomeSignButton.hover();
        return this;
    }

    @Step("Kliknięcie przycisku wyloguj się")
    public TopMenuPage clickLogoutButton() {
        logoutButton.click();
        return this;
    }

    @Step("Asercja: Poprawne wylogowanie się)")
    public TopMenuPage asssertThatLoginButtonAfterCorrectLogoutIsChanged(){
        loginButton.shouldHave(text("Zaloguj się\nZałóż konto"));
        return this;
    }
}
