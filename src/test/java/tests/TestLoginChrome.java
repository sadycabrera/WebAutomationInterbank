package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;
public class TestLoginChrome {
	// variables
	WebDriver driver;
	String tipoBrowser = "chrome";
	LoginPage login;
	HomePage home;
	IndexPage index;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		driver = BasePage.iniciarBrowser(tipoBrowser);
		BasePage.irPagina(BasePage.URL);
		login = new LoginPage(driver);
	}
	
	@Test(dataProvider = "dataLoginExitoso")
	public void testLoginExitoso(String usuario, String clave, String mensaje) throws InterruptedException {
		login.iniciarSesion(usuario, clave);
		// verificación
		home = new HomePage();
		Assert.assertEquals(mensaje, home.getMensajeExito());
	
	}

	@Test(dataProvider = "dataLoginFallido")
	public void testLoginFallido(String usuario, String clave, String mensaje) {
		login.iniciarSesion(usuario, clave);
		// verificación
		index = new IndexPage();
		Assert.assertTrue(index.getMensajeError().contains(mensaje));
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
		
	}
	
	//PROVEEDOR DE DATA
	@DataProvider(name="dataLoginFallido")
	public Object[][] dataLoginFallido()
	{
		return new Object[][] 
				{
				 {"prueba0102@gmail.com", "prueba0103","Enter your userName and password correct"},
				 {"prueba0102@gmail.com", "prueba0104","Enter your userName and password correct"}
				};
	}	
	@DataProvider(name="dataLoginExitoso")
	public Object[][] dataLoginExitoso()
	{
		return new Object[][] 
				{
				 {"prueba0102@gmail.com", "prueba0102", "Login Successfully"}
				};
	}
}
