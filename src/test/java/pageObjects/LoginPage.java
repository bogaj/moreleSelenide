package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement userEmailField = $("#username");
    private SelenideElement passwordField = $("#password-log");
    private SelenideElement loginButton = $x("//button[contains(text(),'Zaloguj się')]");
    private SelenideElement incorrectEmailNotification = $(".form-control-error");

    private SelenideElement incorrectLoginPopup = $x("//div[@class='mn-item mn-type-danger mn-item-push']");
    @Step("Wpisanie adresu e-mail: {usernameEmail")
    public LoginPage typeEmailIntoUserEmailField(String usernameEmail) {
        userEmailField.setValue(usernameEmail);
        return this;
    }

    @Step("Wpisanei hasła: {password]")
    public LoginPage typePasswordIntoPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }
    @Step("Kliknięcie w przycisk do logowania")
    public TopMenuPage clickOnLoginButton(){
        loginButton.click();
        return new TopMenuPage();
    }


    @Step("Asercja: Pojawienie się komunikatu: Podaj poprawny adres e-mail!")
    public LoginPage assertThatIncorrectEmailNotificationIsDisplayedAndIsCorrect(){
        incorrectEmailNotification.shouldHave(text("Podaj poprawny adres e-mail!"));
        return this;

    }

    @Step("Asercja: Pojawienie się popupu Dane logowania nie są poprawne. Zalogowanie nie powiodło się.")
    public LoginPage assertThatIncorrectDataPopupIsDisplayedAndIsCorrect() {
        incorrectLoginPopup.shouldHave(text("Dane logowania nie są poprawne. Zalogowanie nie powiodło się."));
        return this;
    }
}
