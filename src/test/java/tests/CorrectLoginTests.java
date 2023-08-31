package tests;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CorrectLoginTests {

    @Test
            public void correctLoginTest(){
        open("https://www.morele.net/");
        $x("//span[contains(text(),'Zaloguj si')]").click();
        $("#username").setValue("otua.tamotua@op.pl");
        $("#password-log").setValue("TestyME123$");
        $x("//button[contains(text(),'Zaloguj się')]").click();
        $x("//span[normalize-space()='Witaj']").shouldHave(text("Witaj"));
    }

}
