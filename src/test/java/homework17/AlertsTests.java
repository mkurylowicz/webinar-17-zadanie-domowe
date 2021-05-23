package homework17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest{

    @BeforeClass
    public void openPage(){
       driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlertTest(){
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[contains(.,'JS Alert')]"));
        jsAlertButton.click();

        Alert jsAlert = driver.switchTo().alert();
        String alertText = jsAlert.getText();
        jsAlert.accept();
        WebElement confirmationElement = driver.findElement(By.cssSelector("p#result"));
        String confirmationText = confirmationElement.getText();


        Assert.assertEquals(alertText,"I am a JS Alert");
        Assert.assertEquals(confirmationText,"You successfully clicked an alert");
    }

    @Test
    public void jsConfirmTest(){
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[contains(.,'JS Confirm')]"));
        jsConfirmButton.click();

        Alert jsConfirm = driver.switchTo().alert();
        String alertText = jsConfirm.getText();

        Assert.assertEquals(alertText,"I am a JS Confirm");

        driver.switchTo().alert().accept();
        WebElement confirmationElement = driver.findElement(By.cssSelector("p#result"));
        String confirmationText = confirmationElement.getText();
        Assert.assertEquals(confirmationText, "You clicked: Ok");
        jsConfirmButton.click();
        driver.switchTo().alert().dismiss();
        confirmationElement = driver.findElement(By.cssSelector("p#result"));
        confirmationText = confirmationElement.getText();
        Assert.assertEquals(confirmationText, "You clicked: Cancel");
    }

    @Test
    public void jsPromptTest(){
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[contains(.,'JS Prompt')]"));
        jsPromptButton.click();

        String alertText = driver.switchTo().alert().getText();

        Assert.assertEquals(alertText, "I am a JS prompt");

        driver.switchTo().alert().sendKeys("Hello it's me :-)");
        driver.switchTo().alert().accept();
        WebElement confirmationElement = driver.findElement(By.cssSelector("p#result"));
        String confirmationText = confirmationElement.getText();
        Assert.assertEquals(confirmationText, "You entered: Hello it's me :-)");
        jsPromptButton.click();
        driver.switchTo().alert().sendKeys("Hello It's me again ;-)");
        driver.switchTo().alert().dismiss();
        confirmationElement = driver.findElement(By.cssSelector("p#result"));
        confirmationText = confirmationElement.getText();
        Assert.assertEquals(confirmationText, "You entered: null");
    }

}
