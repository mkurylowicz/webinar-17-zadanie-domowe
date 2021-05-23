package homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class PrestaShopTest extends BaseTest{

    @BeforeClass
    public void openPage(){
        driver.get("http://sampleshop.inqa.pl/");
    }

    @Test
    public void copyRightsTest(){
        WebElement copyRightsLink = driver.findElement(By.cssSelector("a[class='_blank']"));
        copyRightsLink.click();

        Set<String> windows = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        for (String windowItem : windows) {
            if(!windowItem.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(windowItem);
            }
        }

        WebElement header = driver.findElement(By.tagName("h2"));
        String headerText = header.getText();

        Assert.assertEquals(headerText, "Discover PrestaShop");
    }
}
