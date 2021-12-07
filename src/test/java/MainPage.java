import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class MainPage extends BasePage{

    @Step("<id> id'li elementin seçili olup olmadığı kontrol edilir")
    public void isElementSelected(String id) {
        try {
            Assert.assertEquals(id+" id'li element seçili halde bulunmuyor","true",appiumDriver.findElement(By.id(id)).getAttribute("selected"));
            log.info(id+" id'li element seçili halde bulunuyor");
        }
        catch (NoSuchElementException e) {
            log.error(id+" id'li element seçili halde bulunmuyor");
        }
    }
}
