package yandex.ouksss;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationParametrizedTest {

    @BeforeEach
    void precondition() {
        Configuration.browserSize = ("1920x1080");
        open("https://demoqa.com/text-box");
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @ValueSource(strings = {"Alex", "Bob"})
    @ParameterizedTest(name = "Проверка отображения формы регистрации \"{0}\"")
    void userNameTest(String userName) {
        $("#userName").setValue(userName);
        $("#submit").click();
        $("#name").shouldHave(text(userName));
    }
    @CsvSource({
            "Alex, alex@email.com",
            "Bob, bob@email.com"
    })
    @ParameterizedTest(name = "Проверка отображения формы регистрации \"{0}\"")
    void complexTest(String userName, String userEmail) {
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#submit").click();
        $("#name").shouldHave(text(userName));
        $("#email").shouldHave(text(userEmail));
    }



}
