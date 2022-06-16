package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.driver.Driver;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DetallesPage;
import com.selenium.pages.ResultadoDespegarPage;

public class test1 extends Driver {
        WebDriver driver = null;
            

    @Test(dataProvider ="providerLugares",description = "Validar Despegar")
    public void buscarAlojamiento(String text) throws Throwable {
            //driver = BaseTest.abrirBrowser("CHROME", "https://www.despegar.com.ar");
            DespegarHomePage despegarHomePage = new DespegarHomePage(driver);
            DetallesPage detallesPage = new DetallesPage(driver);
            ResultadoDespegarPage resultadoDespegarPage = new ResultadoDespegarPage(driver);
            despegarHomePage.clickBtnAlojamiento();
            despegarHomePage.clickPopUp();
            despegarHomePage.clickCookie();
            despegarHomePage.clickInputDestino();
            despegarHomePage.ingresoDestino(text);
            despegarHomePage.presionarEnter();
            despegarHomePage.esperas();
            despegarHomePage.clicklistaCiudades();
            despegarHomePage.clickInputFechas();
            despegarHomePage.clickBtnAdelantarFecha();
            despegarHomePage.clickFechaEntrada();
            despegarHomePage.clickFechaSalida();
            despegarHomePage.aceptarFechas();
            despegarHomePage.clickInputPersonas();
            despegarHomePage.clickBtnAdulto();
            despegarHomePage.clickBtnNinos();
            despegarHomePage.select(8);
            despegarHomePage.clicBtnBuscar();
            despegarHomePage.clickBtnventana();
            resultadoDespegarPage.clickPrimerResultado();
            detallesPage.validarUrl();
            //driver.quit();
    }
    
    
    
    @AfterMethod (alwaysRun = true)
    public void cerrar() {
  	  driver.close();
  	 // Driver.cerrarBrowser(driver);
    }
    
    @BeforeMethod (alwaysRun = true)
    public void abrir() {
  	  //String navegadorTestSuite
  	  driver =  LevantarBrowser("CHROME", "https://www.despegar.com.ar/");
  	 // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  	  
    }
    
    @DataProvider(name="providerLugares")
	public Object [][] providerLugares(){
		return new Object[][] {{"La Plata, Buenos Aires"},{"Tafí del Valle, Tucumán"}};	
	}
}
