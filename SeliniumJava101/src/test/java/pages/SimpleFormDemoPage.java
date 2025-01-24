package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SimpleFormDemoPage {
    WebDriver driver;
    public SimpleFormDemoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    By simpleFormDemoLink= By.linkText("Simple Form Demo");
    By enterMsgTxtBox=By.xpath("//input[@id='user-message']");
    By chekedValBtn=By.id("showInput");
    By displayMsg=By.id("message");
    String msg="Welcome to LambdaTest";

    public void validateSimpleForm(){
        clickSimpleFormLink();
        validateUrl();
        enterMessage(msg);
        clickChekedValueBtn();
        validateDisplyMessage();
    }

    public  void clickSimpleFormLink(){
        driver.findElement(simpleFormDemoLink).click();
    }
    public void  validateUrl( ){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("simple-form-demo"));
        System.out.println("Validated that URL contains the expected text: simple-form-demo");
    }

    public void enterMessage(String msg){
        driver.findElement(enterMsgTxtBox).sendKeys(msg);
    }

    public  void clickChekedValueBtn(){
        driver.findElement(chekedValBtn).click();
    }

    public void validateDisplyMessage(){
        Assert.assertEquals(driver.findElement(displayMsg).getText(),msg);
        System.out.println("Validated that Displayed message is :"+msg);
    }


}
