package sprint4.units;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Questions {
    private final WebDriver webDriver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //private final By question = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //private final By answer = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");


    public Questions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public Questions openUrl() {
        webDriver.get(URL);
        return this;
    }

    public Questions scoll(By question){
        WebElement element = webDriver.findElement(question);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public Questions clickQuestion(By question) {
        webDriver.findElement(question).click();
        return this;
    }

    public boolean CheckAnswer(By answer) {
        return webDriver.findElements(answer).isEmpty();
    }

}
