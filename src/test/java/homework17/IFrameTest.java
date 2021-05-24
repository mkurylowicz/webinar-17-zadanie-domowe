package homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest{
    @BeforeClass
    public void openPage(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
    }

    @Test
    public void iFrame(){
        WebElement agree = driver.findElement(By.id("accept-choices"));
        agree.click();

        WebElement run = driver.findElement(By.cssSelector("button[class=\"w3-button w3-bar-item w3-hover-white w3-hover-text-green\"]"));
        run.click();

        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));

        //WebElement loginButton = driver.findElement(By.cssSelector("a#w3loginbtn"));
        WebElement loginButton = driver.findElement(By.cssSelector(".w3-bar-item.w3-btn.bar-item-hover.w3-right"));

    }
}
