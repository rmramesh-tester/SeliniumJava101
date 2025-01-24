package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SliderDemoPage {
    WebDriver driver;
    public SliderDemoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    By dragAndDropLink= By.linkText("Drag & Drop Sliders");
    By slier=By.xpath("//div[@id='slider3']");
    By rangeValue=By.id("rangeSuccess");

    public void validateSlider(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(dragAndDropLink).click();
        Actions action=new Actions(driver);
        action.dragAndDropBy(driver.findElement(slier),195,0).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(rangeValue));
        String actualRangeValue=driver.findElement(rangeValue).getText().trim();
        Assert.assertEquals(actualRangeValue,"95");
        System.out.println("Validated that Current Displayed range value is :"+actualRangeValue);

    }
}
