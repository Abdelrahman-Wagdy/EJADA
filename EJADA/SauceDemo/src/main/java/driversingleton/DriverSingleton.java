package driversingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyFileHandler;


public class DriverSingleton {
    PropertyFileHandler propertyFileHander = new PropertyFileHandler("src/test/resources/config.properties");
    private static DriverSingleton uniqueInstance = null;
    private WebDriver webDriver = null;
    private DriverSingleton(){
        propertyFileHander.loadPropertiesFile();
        if (webDriver == null){
            System.out.println("Initiating the driver, chrome driver is the default");
            setDriver(System.getProperty("browser"));
        }
        webDriver.manage().window().maximize();
    }
    public static WebDriver getDriver(){
        if (uniqueInstance == null){
            uniqueInstance = new DriverSingleton();
        }
        return uniqueInstance.webDriver;
    }
    private void setDriver(String driver){
        if (webDriver == null){
            switch (driver){
                case "FIREFOX":
                    System.out.println("Initiating the firefox driver");
                    webDriver = new FirefoxDriver();
                    break;
                case "CHROME":
                default:
                    System.out.println("Initiating the chrome driver");
                    webDriver = new ChromeDriver();
                    break;
            }
        }
    }
}
