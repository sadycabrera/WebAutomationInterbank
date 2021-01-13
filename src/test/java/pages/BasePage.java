package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Configuracion;

public abstract class BasePage {

	public static WebDriver driver;
	public static final String URL = "http://demo.guru99.com/test/newtours/";

	public BasePage(String pagina) {
		System.out.println("Web Page: " + pagina);
	}

	public static WebDriver iniciarBrowser(String nombre) {
		if (nombre.equals(Configuracion.CHROME)) {
			System.setProperty(Configuracion.TIPO_DRIVER_CHROME, Configuracion.PATH_DRIVER_CHROME);
			driver = new ChromeDriver();
		} 
		else if (nombre.equals(Configuracion.FIREFOX)) {
			System.setProperty(Configuracion.TIPO_DRIVER_FIREFOX, Configuracion.PATH_DRIVER_FIREFOX);
			driver = new FirefoxDriver();
		}
		else if (nombre.equals(Configuracion.EDGE))

		{
			System.setProperty(Configuracion.TIPO_DRIVER_EDGE, Configuracion.PATH_DRIVER_EDGE);
			driver = new EdgeDriver();
		}
		return driver;
	}

	public void quit() {
		driver.quit();
	}

	public static void irPagina(String URL) {
		driver.get(URL);
	}

	public void ingresarTexto(WebElement elemento, String texto) {
		elemento.sendKeys(texto);
	}

	public void clickBoton(WebElement elemento) {
		elemento.click();
	}

	public void limpiar(WebElement elemento) {
		elemento.clear();
	}

	public String obtenerTexto(WebElement elemento) {
		return elemento.getText();
	}

	public void esperaExplicita(WebElement elemento, int time) {
		WebDriverWait espera = new WebDriverWait(driver, time);
		espera.until(ExpectedConditions.visibilityOf(elemento));
	}
}
