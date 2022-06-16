package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DespegarHomePage {

    @FindBy(xpath="//*[@class='shifu-icon-product shifu-3-icon-hotels']")
    WebElement btnAlojamiento;
    @FindBy(xpath="/html/body/nav/div[3]/div[1]/i")
    WebElement popUp;
    @FindBy(xpath="//a[@class='lgpd-banner--button eva-3-btn -white -md']")
    WebElement cookie;
    @FindBy(xpath="//div[@class='input-container']/input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
    WebElement inputDestino;
    @FindBy(xpath="//li[@class='item -active']")
    WebElement listaCuidades;
    @FindBy(xpath="//input[@placeholder='Entrada']")
    WebElement inputFechas;
    @FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//a[@class='calendar-arrow-right']")
    WebElement btnAdelantarMes;
    @FindBy(xpath="//div[@data-month='2022-08']/div[3]/div[1]/div[1]")
    WebElement fechaEntrada;
    @FindBy(xpath="//div[@data-month='2022-08']/div[3]/div[19]/div[1]")
    WebElement fechaSalida;
    @FindBy(xpath="//button[@class='sbox5-3-btn -primary -md']")
    WebElement btnAplicar;
    @FindBy(xpath="//div[@class='sbox5-3-first-input-wrapper']")
    WebElement inputPersonas;
    @FindBy(xpath="//div[@class='stepper__room']/div[2]/div[1]/div[2]/div[1]/button[2]")
    WebElement btnSelectAdulto;
    @FindBy(xpath="//div[@class='stepper__room']/div[2]/div[2]/div[2]/div[1]/button[2]")
    WebElement btnSelectNinos;
    @FindBy(xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='stepper__room__footer ']//*[@class='sbox5-3-btn -md -primary']//*[@class='btn-text']")
    WebElement btnAplicarPers;
    @FindBy(xpath="//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']")
    WebElement btnBuscar;
    @FindBy(css = "select[class='select']")
    WebElement edad;
    @FindBy (xpath= "//*[@class='tooltip-close eva-3-icon-close']")
    WebElement Ventana;
    String lugarDestino = "Cordoba";
    int numero = 8;

    private WebDriver driver = null;
    WebDriverWait wait;

    public DespegarHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void esperas() throws InterruptedException {
        Thread.sleep(3000);
    }
    public void clicBtnBuscar(){
        this.btnBuscar.click();
    }

    //----------------------------------------------------------------------------/
    //Seleccion de la ciudad
    public void clickBtnAlojamiento(){
        wait.until(ExpectedConditions.elementToBeClickable(this.btnAlojamiento));
        this.btnAlojamiento.click();
    }
    public void clickPopUp(){
        if(this.popUp.isDisplayed()) {
            this.popUp.click();
        }
    }
    public void clickCookie(){
        if(this.cookie.isDisplayed()) {
            this.cookie.click();
        }
    }
    public void clickInputDestino(){
        this.inputDestino.click();
    }
    /*public void ingresarLugar(String providerLugares) throws Throwable {
		this.inputDestino.click();
		this.inputDestino.sendKeys(providerLugares);
		//wait.until(ExpectedConditions.visibilityOf(listaCuidades));
		Thread.sleep(3000);
		inputDestino.sendKeys(Keys.CONTROL);
		Thread.sleep(3000);
		inputDestino.sendKeys(Keys.ENTER);
		}*/
		
    public void ingresoDestino(String providerLugares) throws Throwable{
    	Thread.sleep(5000);
        this.inputDestino.sendKeys(providerLugares);

    }
    public void presionarEnter() throws InterruptedException {
        Thread.sleep(5000);
        this.inputDestino.sendKeys(Keys.CONTROL);
    }
    public void clicklistaCiudades() throws InterruptedException {
        wait.until((ExpectedConditions.elementToBeClickable(this.listaCuidades)));
        //Thread.sleep(1000);
        this.listaCuidades.click();
    }
    //----------------------------------------------------------------------------------/
    //Seleccion de fechas
    public void clickInputFechas(){
        this.inputFechas.click();
    }
    public void clickBtnAdelantarFecha(){
        wait.until(ExpectedConditions.elementToBeClickable(this.btnAdelantarMes));
        this.btnAdelantarMes.click();
    }
    public void clickFechaEntrada(){
        wait.until(ExpectedConditions.elementToBeClickable(this.fechaEntrada));
        this.fechaEntrada.click();
    }
    public void clickFechaSalida(){
        wait.until(ExpectedConditions.elementToBeClickable(this.fechaSalida));
        this.fechaSalida.click();
    }
    public void aceptarFechas(){
        this.btnAplicar.click();
    }
    //----------------------------------------------------------------------------------/
    //Seleccion de personas
    public void clickInputPersonas(){
        this.inputPersonas.click();
    }
    public void clickBtnAdulto(){
        wait.until(ExpectedConditions.elementToBeClickable(this.btnSelectAdulto));
        this.btnSelectAdulto.click();
    }
    public void clickBtnNinos(){
        wait.until(ExpectedConditions.elementToBeClickable(this.btnSelectNinos));
        this.btnSelectNinos.click();
    }
    public void select(int numero) {
        Select edad = new Select(this.edad);
        edad.selectByIndex(numero);
    }
    
    public void clickBtnventana(){
        wait.until(ExpectedConditions.elementToBeClickable(this.Ventana));
        this.Ventana.click();
    }
 

}
