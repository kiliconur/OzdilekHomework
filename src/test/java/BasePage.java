import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest{
    @Step("element <element> gözükene kadar bekle")
    public void waitForElement(String element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(element)));
            log.error(element+" elementi beklendi");
        }
        catch (TimeoutException e)
        {
            log.error(element+" elementi beklendi fakat bekleme süresi zamanaşımına uğradı");
            e.printStackTrace();
        }
    }

    @Step("<time> saniye bekle")
    public void waitForSecond(int time) throws InterruptedException {
        Thread.sleep(1000L *time);
        log.error(time+" saniye beklendi");

    }

    @Step("<id> id'li elemente tıkla")
    public void clickById(String id){
        appiumDriver.findElement(By.id(id)).click();
        log.error(id + " id'li elemente tıklandı");
    }

    @Step("<id> id'li elementlerden <text> içerene tıkla")
    public void clickByIdContainsText(String id, String text){
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/recyclerCategories")).findElementByXPath("//*[contains(@text,'"+text+"')]").click();
        log.error(text + " yazan " + id + " id'li elemente tıklandı");
    }

    @Step("<id> id'li elemete <text> değerini yaz")
    public void sendKeysById(String id, String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        log.error(id+" id'li elemente " + text + " değeri yazıldı");
    }

    @Step("<x> ve <y> koordinatlarından <x2> ve <y2> koordinatlarına kadar kaydır")
    public void swipeByCoordinates(int x, int y, int x2, int y2) {
        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(x,y));
        action.moveTo(PointOption.point(x2,y2));
        action.release();
        action.perform();
        log.error("ekran aşağı kaydırıldı");
    }

    @Step("<id> id'li elementin varlığı kontrol edilir")
    public void isElementNull(String id) {
        try {
            Assert.assertNotNull("Element mevcut değil",appiumDriver.findElement(By.id(id)));
            log.error(id + " id'li element mevcut");
        }
        catch (NoSuchElementException e) {
            log.error(id + " id'li elemente mevcut değil");
        }
    }
}
