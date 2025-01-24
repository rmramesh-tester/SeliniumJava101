package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FormFillDemoPage {
    WebDriver driver;
    public FormFillDemoPage( WebDriver drive){
        this.driver=drive;
        PageFactory.initElements(driver,this);
    }

    //Locators
    By inputFormSubmitLink= By.linkText("Input Form Submit");
    By nameInputBox=By.name("name");
    By emailInputBox=By.id("inputEmail4");
    By passwordInputBox=By.xpath("//input[@id='inputPassword4']");
    By companyInputBox=By.xpath("//input[@id='company']");
    By websiteInputBox=By.xpath("//input[@id='websitename']");
    By countryDD=By.xpath("//select[@name='country']");
    By cityInputBox= By.xpath("//input[@id='inputCity']");
    By address1InputBox=By.xpath("//input[@id='inputAddress1']");
    By address2InputBox= By.xpath("//input[@id='inputAddress2']");
    By stateInputBox=By.xpath("//input[@id='inputState']");
    By zipInputBox=By.xpath("//input[@id='inputZip']");
    By submitBtn=By.xpath("//button[normalize-space()='Submit']");
    By successMsg=By.xpath("//p[@class='success-msg hidden']");


public void formFillValidation() throws InterruptedException {
    clickInputForm();
    validateErrorMsg();
    enterName("Ramesh");
    enterEmail("Demo@yahoo.com");
    enterPass("TestDemo");
    enterCompany("Test company");
    enterEnterWebsite("Test website");
    selectCountry("United States");
    enterEnterCity("New Mexico");
    enterAddres1("14 texas");
    enterAddress2("California");
    enterstate("Alabama");
    enterZip("500012");
    clickSubmitBtn();
    validateSuccessMsg();
}

//public  void clickInputForm(){
//    driver.findElement(inputFormSubmitLink).click();
//}
public void clickInputForm() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(inputFormSubmitLink)).click();
}
//public void validateErrorMsg() throws InterruptedException {
//    driver.findElement(submitBtn).click();
//    String expectedErrorMsg="Please fill out this field.";
//    WebElement activeElement = driver.switchTo().activeElement();
//    //String actualErrorMsg= driver.findElement(nameInputBox).getAttribute("validationMessage");
//    String actualErrorMsg = activeElement.getAttribute("validationMessage");
//    Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
//    System.out.println("Validated that Displayed Error message is :"+actualErrorMsg);
//}
public void validateErrorMsg() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.findElement(submitBtn).click();
    WebElement activeElement = wait.until(ExpectedConditions.visibilityOf(driver.switchTo().activeElement()));
    String expectedErrorMsg = "Please fill out this field.";
    String actualErrorMsg = activeElement.getAttribute("validationMessage");
    Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    System.out.println("Validated error message: " + actualErrorMsg);
}
public void enterName(String name){
    driver.findElement(nameInputBox).sendKeys(name);

}
public void enterEmail(String email){
    driver.findElement(emailInputBox).sendKeys(email);

}
public void enterPass(String pass){
    driver.findElement(passwordInputBox).sendKeys(pass);

}
public  void enterCompany(String company){
    driver.findElement(companyInputBox).sendKeys(company);

}
public void enterEnterWebsite(String web){
    driver.findElement(websiteInputBox).sendKeys(web);


}
public void selectCountry(String country){
    Select sel=new Select(driver.findElement(countryDD));
    sel.selectByVisibleText(country);

}
public void enterEnterCity(String city){
    driver.findElement(cityInputBox).sendKeys(city);

}
public void enterAddres1(String add1){
    driver.findElement(address1InputBox).sendKeys(add1);

}
public void enterAddress2(String add2){
    driver.findElement(address2InputBox).sendKeys(add2);

}
public void enterstate(String state){
    driver.findElement(stateInputBox).sendKeys(state);

}
public void enterZip(String zip){
    driver.findElement(zipInputBox).sendKeys(zip);

}
public void clickSubmitBtn(){
    driver.findElement(submitBtn).click();

}
//public void validateSuccessMsg(){
//    String actualMssage= driver.findElement(successMsg).getText();
//    String expectedMessage="Thanks for contacting us, we will get back to you shortly.";
//    Assert.assertEquals(actualMssage,expectedMessage);
//    System.out.println("Validated that After submit displayed success message is :"+actualMssage);
//}
public void validateSuccessMsg() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
    String actualMessage = successElement.getText();
    String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
    Assert.assertEquals(actualMessage, expectedMessage);
    System.out.println("Validated success message: " + actualMessage);
}
}
