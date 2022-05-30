import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DespegarTest {
	String lugarDestino = "Cordoba";	
	WebDriver driver;
	
	@Test(description = "Validar la palabra Bienvenidos")
	public void ValidarBusquedadespegar() throws Exception { 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\CURSO AUTOMATIZADO\\chromedriver.exe"); WebDriver driver = new ChromeDriver();
	driver.get("https://www.despegar.com.ar/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//Selecciona la opcion de Alojamiento en la pagina principal de Despegar.com
	WebElement btnAlojamiento = driver.findElement(By.xpath("//*[@class='shifu-icon-product shifu-3-icon-hotels']")); 
	btnAlojamiento.click();
	
	//Cierra el popUp emergente
	WebElement popUp = driver.findElement(By.xpath("/html/body/nav/div[3]/div[1]/i"));
	popUp.click();
	
	//Acepta las cookies de la web
	WebElement cookies = driver.findElement(By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]"));
	cookies.click();	
		
	//Nos permite seleccionar el destino
		WebElement destino = driver.findElement(By.xpath("//div[@class='input-container']/input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']"));
		destino.click();
		destino.sendKeys(lugarDestino);
		Thread.sleep(1000);
		destino.sendKeys(Keys.CONTROL);
		WebElement listaCiudades = driver.findElement(By.xpath("//li[@class='item -active']"));
		WebElement primeraPosicion = driver.findElement(By.xpath("//li[@class='item -active']"));
		primeraPosicion.click();
	
	//Despliega el calendario para seleccionar los dias de alojamiento
	WebElement fechas = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
	fechas.click();	
	Thread.sleep(3000);	
	WebElement adelantarMes = driver.findElement(By.xpath("//*[@id=\"component-modals\"]/div[4]/div[1]/div[2]/a[2]"));
	adelantarMes.click();
	
	Thread.sleep(3000);	
	
	//WebElement fechaEntrada = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));
	WebElement fechaEntrada = driver.findElement(By.xpath	("//div[@data-month='2022-07']/div[3]/div[1]/div[1]"));
	fechaEntrada.click();	
	Thread.sleep(2000);	
	//WebElement fechaSalida = driver.findElement(By.xpath("//*[@id=\"component-modals\"]/div[4]/div[1]/div[2]/div[1]/div[3]/div[25]/div"));
	WebElement fechaSalida = driver.findElement(By.xpath("//div[@data-month='2022-07']/div[3]/div[19]/div[1]"));
	fechaSalida.click();	
	WebElement btnAplicar = driver.findElement(By.xpath("//*[@class='sbox5-3-btn -primary -md']"));
	btnAplicar.click();
	
	
	//Despliega la opción para seleccionar las paersonas que viajaran
	WebElement personas = driver.findElement(By.xpath("//div[@class='sbox5-3-first-input-wrapper']"));
	personas.click();
	Thread.sleep(2000);	
	WebElement btnAdulto = driver.findElement(By.xpath("//div[@class='stepper__room']/div[2]/div[1]/div[2]/div[1]/button[2]"));
	btnAdulto.click();	
	Thread.sleep(1000);	
	WebElement btnNiños = driver.findElement(By.xpath("//div[@class='stepper__room']/div[2]/div[2]/div[2]/div[1]/button[2]"));
	btnNiños.click();	
	Thread.sleep(2000);
	Select edad = new Select(driver.findElement(By.cssSelector("select[class='select']")));	
	edad.selectByIndex(8);	
	WebElement btnAplicarPersonas = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//*[@class='stepper__room__footer ']//*[@class='sbox5-3-btn -md -primary']//*[@class='btn-text']"));
	btnAplicarPersonas.click();	
	
	//Presiona el boton buscar
		Thread.sleep(1000);	
		WebElement btnBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));
		btnBuscar.click();
	
	
	//Redireccion y validacion 
	Thread.sleep(5000);
	String titulo = "Alojamientos - Despegar";	
	Assert.assertEquals(titulo, driver.getTitle());
	System.out.println("Te encuentras en la pagina de Alojamientos");
	
	
	WebElement primerAlojamiento = driver.findElement(By.xpath("//div[@class='cluster-container -eva-3-shadow-line']/div[1]/div[1]/div[2]/div[1]/*[1]"));
	primerAlojamiento.click();	
	
	Thread.sleep(2000);
	System.out.println("Se realiza la redirección de manera correcta!!");
	
	driver.quit();
	
	}
	
	
}	
	

