package sprint4.units;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FormOrder {
    private final WebDriver webDriver;
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By cookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private static String name = "Саша";
    private final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private static String lastName = "Иванов";
    private final By inputAddres = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static String addres = "Москва";
    private final By inputSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private static String subwayStation = "Черкизовская";
    private final By choiceSubwayStation = By.xpath(".//div[text()='Черкизовская']");
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static String phonenumber = "+79805614360";
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By inputDate = By.xpath(".//div[@aria-label='Choose понедельник, 10-е июня 2024 г.']");
    private final By clickDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static String date = "10.06.2024";
    private final By inputPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By choicePeriod = By.xpath(".//div[text()='сутки']");
    private final By choiceColor = By.xpath(".//input[@id='black']");
    private final By orderFinalButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By yesButton = By.xpath(".//button[text()='Да']");
    private final By orderSuccess = By.xpath(".//div[text()='Заказ оформлен']");



    public FormOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public FormOrder openUrl() {
        webDriver.get(URL);
        return this;
    }

    public FormOrder clickCookie(){
        webDriver.findElement(cookie).click();
        return this;
    }

    public FormOrder clickOrder() {
        webDriver.findElement(orderButton).click();
        return this;
    }

    public FormOrder enterName() {
        webDriver.findElement(inputName).sendKeys(name);
        return this;
    }

    public FormOrder enterLastName() {
        webDriver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    public FormOrder enterAddres() {
        webDriver.findElement(inputAddres).sendKeys(addres);
        return this;
    }

    public FormOrder enterSubwayStation() {
        webDriver.findElement(inputSubwayStation).sendKeys(subwayStation);
        webDriver.findElement(choiceSubwayStation).click();
        return this;
    }

    public FormOrder enterPhoneNumber() {
        webDriver.findElement(inputPhoneNumber).sendKeys(phonenumber);
        return this;
    }

    public FormOrder clickButtonNext() {
        webDriver.findElement(buttonNext).click();
        return this;
    }

    public FormOrder clickDate() {
        webDriver.findElement(clickDate).click();
        webDriver.findElement(clickDate).sendKeys(date);
        return this;
    }
    public FormOrder enterDate() {
        new WebDriverWait(webDriver, Duration.of(3, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeClickable(inputDate));
        webDriver.findElement(inputDate).click();
        return this;
    }

    public FormOrder enterPeriod() {
        webDriver.findElement(inputPeriod).click();
        webDriver.findElement(choicePeriod).click();
        return this;
    }

    public FormOrder enterColor() {
        webDriver.findElement(choiceColor).click();
        return this;
    }

    public FormOrder clickOrderFinal() {
        webDriver.findElement(orderFinalButton).click();
        return this;
    }

    public FormOrder clickYes() {
        webDriver.findElement(yesButton).click();
        return this;
    }

    public boolean checkStatusOrder() {
        return webDriver.findElements(orderSuccess).isEmpty();
    }



}
