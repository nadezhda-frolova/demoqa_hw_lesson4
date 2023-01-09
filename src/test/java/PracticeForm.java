import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    File file = new File("src/test/resources/file.jpg");
    @Test
    void practiceFormTest(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Надежда");
        $("#lastName").setValue("Фролова");
        $("#userEmail").setValue("test@yandex.ru");
        $("#genterWrapper").shouldHave(text("Female")).click();
        $("#userNumber").setValue("9127420338");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("November")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1984")).click();
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Актобе");
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

            }
}
