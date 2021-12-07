import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class SearchPage extends BasePage{

    @Step("<id> id'li elementlerden rastgele bir ürün seçilir")
    public void clickRandomElement(String selectorid) {
        List<MobileElement> elements;
        elements = appiumDriver.findElements(By.id(selectorid));
        int randomNumber = (int)(Math.random() * elements.size());
        elements.get(randomNumber).click();
    }

}
