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
        open("https://demoqa.com/text-box");            // Открытие страницы с формой
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    @ValueSource(strings = {"Alex", "Bob"})
    @ParameterizedTest(name = "Проверка отображения формы регистрации \"{0}\"")
    void userNameTest(String userName) {
        $("#userName").setValue(userName);                     // Ввести имя пользователя в форму
        $("#submit").click();                                  // Нажать кнопку Submit
        $("#output").shouldHave(text(userName)); // Проверить правильность введенных данных
    }

    @CsvSource({
            "Alex, alex@email.com, mira 20",
            "Bob, bob@email.com, nowar 22"
    })
    @ParameterizedTest(name = "Проверка отображения формы регистрации \"{0}\"")
    void complexTest(String userName, String userEmail, String userAddress) {
        $("#userName").setValue(userName);                     // Ввести имя пользователя в форму
        $("#userEmail").setValue(userEmail);                   // Ввести почту пользователя в форму
        $("#currentAddress").setValue(userAddress);            // Ввести адрес пользователя в форму
        $("#submit").click();                                  // Нажать кнопку Submit
        $("#output").shouldHave(text(userName), text(userEmail), text(userAddress)); // Проверить правильность введенных данных
    }
}
