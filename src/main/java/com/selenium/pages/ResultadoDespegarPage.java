package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.time.Duration;
import java.util.logging.Handler;

public class ResultadoDespegarPage {
    private WebDriver driver = null;


    @FindBy(xpath = "//div[@class='cluster-container -eva-3-shadow-line']/div[1]/div[1]/div[2]/div[1]/*[1]")
    WebElement primerResultado;

    public ResultadoDespegarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public DetallesPage clickPrimerResultado(){

        this.primerResultado.click();
       for (String winHandle : driver.getWindowHandles()){
           driver.switchTo().window(winHandle);
       }
      

        return new DetallesPage(this.driver);
    }

}
