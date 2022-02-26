package yandex.ouksss;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationParametrizedTest {

    @BeforeEach
    void precondition(){
        Configuration.browserSize = ("1920x1080");
        open("https://demoqa.com/automation-practice-form");
    }
    @AfterEach
void afterEach(){
        Selenide.closeWebDriver();
    }
    @ValueSource(strings = {"Alex", "Bob"})
    @ParameterizedTest(name = "Проверка отображения формы регистрации \"{0}\"")
    void openTest(String testData){
        $("#firstName").setValue(testData);
    }
}
