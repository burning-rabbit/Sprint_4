package sprint4.units.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FormOrder {
    private final WebDriver webDriver;
    //Адрес главной страницы
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    //Локатор кнопки с подтверждением использования куки
    private final By cookie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    //Кнопка заказать сверху страницы
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Кнопка заказать внизу страницы
    private final By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле ввода имени
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    private final By inputAddres = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода станции метро
    private final By inputSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор выбора станции метро
    private final By choiceSubwayStation = By.xpath(".//div[@class='select-search__select'][1]");
    //Поле ввода номера телефона
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки далее
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор даты доставки
    private final By inputDate = By.xpath(".//div[@aria-label='Choose понедельник, 10-е июня 2024 г.']");
    //Поле ввода даты доставки
    private final By clickDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле выбора периода аренды
    private final By inputPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Локкатор выбора периода аренды
    private final By choicePeriod = By.xpath(".//div[text()='сутки']");
    //Локатор выбора цвета
    private final By choiceColor = By.xpath(".//input[@id='black']");
    //Локатор кнопка "Заказать" в конце формы заказа
    private final By orderFinalButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор кнопки "Да" во всплывающем окне
    private final By yesButton = By.xpath(".//button[text()='Да']");
    //Локатор текста "Заказ оформлен" при усппешном заказе
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

    public FormOrder enterName(String name) {
        webDriver.findElement(inputName).sendKeys(name);
        return this;
    }

    public FormOrder enterLastName(String lastName) {
        webDriver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    public FormOrder enterAddres(String addres) {
        webDriver.findElement(inputAddres).sendKeys(addres);
        return this;
    }

    public FormOrder enterSubwayStation(String subwayStation) {
        webDriver.findElement(inputSubwayStation).sendKeys(subwayStation);
        webDriver.findElement(choiceSubwayStation).click();
        return this;
    }

    public FormOrder enterPhoneNumber(String phonenumber) {
        webDriver.findElement(inputPhoneNumber).sendKeys(phonenumber);
        return this;
    }

    public FormOrder clickButtonNext() {
        webDriver.findElement(buttonNext).click();
        return this;
    }

    public FormOrder clickDate(String date) {
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

    public FormOrder clickOrderButtonBottom() {
        webDriver.findElement(orderButtonBottom).click();
        return this;
    }

    public boolean checkStatusOrder() {
        return webDriver.findElements(orderSuccess).isEmpty();
    }



}
