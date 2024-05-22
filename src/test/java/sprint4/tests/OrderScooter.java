package sprint4.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint4.units.FormOrder;

import java.util.concurrent.TimeUnit;

public class OrderScooter {

    private WebDriver webDriver;

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
                .enterName()
                .enterLastName()
                .enterAddres()
                .enterSubwayStation()
                .enterPhoneNumber()
                .clickButtonNext()
                .clickDate()
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
