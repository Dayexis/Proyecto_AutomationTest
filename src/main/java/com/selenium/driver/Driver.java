package com.selenium.driver;

import com.google.common.base.FinalizableReferenceQueue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class Driver {

    private enum browsers {
        FIREFOX, CHROME
    };

    public static WebDriver LevantarBrowser (String browserName, String URL) {
        WebDriver driver = null;
        switch (browsers.valueOf(browserName)) {
            case CHROME:{
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case FIREFOX:{
                System.setProperty("webdriver.gecko.driver", "src/main/resources/firefox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            default: {
                System.out.println("Browser equivocado");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        driver.get(URL);
        driver.manage().window().maximize();
        return driver;
    }

    public static void cerrarBrowser (WebDriver driver) {
        driver.close();
    }
    
    




}
