package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DetallesPage {
    private WebDriver driver = null;
    WebDriverWait wait;
    @FindBy(xpath = "/html/body/aloha-app-root/aloha-detail/div/div[3]/div/div/div/aloha-accommodation-name/h1")
    WebElement selector;
    public DetallesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void validarUrl() throws InterruptedException {
        Thread.sleep(5000);

            Assert.assertEquals(driver.getCurrentUrl().contains("detail"), true);
            System.out.println("Nos encontramos en la pagina de resultado cuya URL es: " + this.driver.getCurrentUrl());

    }
}
