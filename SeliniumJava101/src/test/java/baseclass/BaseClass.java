package baseclass;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseClass {

    public RemoteWebDriver driver=null;
    public String username="r_ramesh";
    final String accesKey="GHM4hvgSXw5Z28HW74JBQgnax1mEYbXaRGa0zL4sNXYPSJBunu";
    public String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

    @Parameters(value = {"Browser","Version","Platform"})
    @BeforeMethod
    public  void setup(String browserName,String browserVersion,String platform) throws MalformedURLException {
        desiredCapabilities.setCapability("browserName",browserName);
        desiredCapabilities.setCapability("version",browserVersion);
        desiredCapabilities.setCapability("platform",platform);
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accesKey", accesKey);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("build", "Selinium 101 LambdaTest");
        ltOptions.put("project", "Selinium 101 LambdaTest");
        ltOptions.put("name", "Selinium 101 LambdaTest Assignment");
        ltOptions.put("console",true);
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("plugin", "java-testNG");
        desiredCapabilities.setCapability("LT:Options", ltOptions);
        try{
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + accesKey + hub),desiredCapabilities);
        }catch (MalformedURLException exception){
            exception.printStackTrace();
        }

    }

    @AfterMethod
    public void tearDown(){
    driver.quit();

    }

    public void NavigateUrl(){
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
    }
}
