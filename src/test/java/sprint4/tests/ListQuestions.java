package sprint4.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint4.units.Questions;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class ListQuestions {
    private WebDriver webDriver;
    private static By question;
    private static By answer;

    public ListQuestions(By question, By answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']"),
                        By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']") },
                { By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']"),
                By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']") },
                { By.xpath(".//div[text()='Как рассчитывается время аренды?']"),
                By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']") },
                { By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']"),
                By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']") },
                { By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']"),
                By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']") },
                { By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']"),
                By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']") },
                { By.xpath(".//div[text()='Можно ли отменить заказ?']"),
                By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']") },
                { By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']"),
                By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']")}
        };
    }



    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void checkAnswer() {

        Questions questions = new Questions(webDriver);

        questions.openUrl()
                 .scoll(question)
                 .clickQuestion(question);

        Assert.assertFalse("Что-то пошло не так(",questions.CheckAnswer(answer));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
