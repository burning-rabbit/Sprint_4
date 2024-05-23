package sprint4.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint4.units.pageObject.FormOrder;


@RunWith(Parameterized.class)
public class OrderScooter {

    private WebDriver webDriver;
    private static String name; //Имя заказщика
    private static String lastName; //Фамилия заказчика
    private static String addres; //Адрес заказчика
    private static String subwayStation; //Станция метро
    private static String phonenumber; //Номер телефона заказчика
    private static String date; //Дата доставки


    public OrderScooter(String name, String lastName, String addres, String subwayStation, String phonenumber, String date) {
        this.name = name;
        this.lastName = lastName;
        this.addres = addres;
        this.subwayStation = subwayStation;
        this.phonenumber = phonenumber;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Саша", "Иванов", "Москва", "Черкизовская", "+79805614360", "10.06.2024", },
                { "Маша", "Сидорова", "Москва пл. Победы", "Сокольники", "+79034803761", "11.06.2024" }
        };
    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
    }


    @Test
    public void order() {
        FormOrder formOrder = new FormOrder(webDriver);

        formOrder.openUrl()
                .clickCookie()
                .clickOrder()
                .enterName(name)
                .enterLastName(lastName)
                .enterAddres(addres)
                .enterSubwayStation(subwayStation)
                .enterPhoneNumber(phonenumber)
                .clickButtonNext()
                .clickDate(date)
                .enterDate()
                .enterPeriod()
                .enterColor()
                .clickOrderFinal()
                .clickYes();

        Assert.assertFalse("Что-то пошло не так(", formOrder.checkStatusOrder());
    }

    @Test
    public void orderBottomButton() {
        FormOrder formOrder = new FormOrder(webDriver);

        formOrder.openUrl()
                .clickCookie()
                .clickOrderButtonBottom()
                .enterName(name)
                .enterLastName(lastName)
                .enterAddres(addres)
                .enterSubwayStation(subwayStation)
                .enterPhoneNumber(phonenumber)
                .clickButtonNext()
                .clickDate(date)
                .enterDate()
                .enterPeriod()
                .enterColor()
                .clickOrderFinal()
                .clickYes();

        Assert.assertFalse("Что-то пошло не так(", formOrder.checkStatusOrder());
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }
}
