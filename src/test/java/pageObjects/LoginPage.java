package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement userEmailField = $("#username");
    private SelenideElement passwordField = $("#password-log");
    private SelenideElement loginButton = $x("//button[contains(text(),'Zaloguj się')]");


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
    public TopMenuPage clikOnLoginButton(){
        loginButton.click();
        return new TopMenuPage();
    }
}
