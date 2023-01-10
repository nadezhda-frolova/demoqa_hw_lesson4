package practiceForm;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillUserDataTest {
    File file = new File("src/test/resources/file.jpg");
    @Test
    void successfulFillUserDataTest(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Надежда");
        $("#lastName").setValue("Фролова");
        $("#userEmail").setValue("test@yandex.ru");
        $("#genterWrapper").$(byText("Female")).click();
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
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(exactText("Надежда Фролова"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(exactText("test@yandex.ru"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(exactText("Female"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(exactText("9127420338"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(exactText("04 November,1984"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(exactText("Maths"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(exactText("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(exactText("file.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(exactText("Актобе"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(exactText("NCR Delhi"));

    }
}
