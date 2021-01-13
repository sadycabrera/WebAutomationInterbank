package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	//variables
	@FindBy(how = How.NAME,using = "userName")
	private WebElement txtUser;
	@FindBy(how = How.NAME, using = "password")
	private WebElement txtPass;
	@FindBy(how = How.NAME, using = "submit")
	private WebElement btnLogin;

	public LoginPage(String browser, String URL)
	{
		super("Login");
	    if (!driver.getTitle().equals("Welcome: Mercury Tours")) {
	        throw new IllegalStateException("This is not Correct Page," +
	              " current page is: " + driver.getCurrentUrl());
	      }
	    //Inicializamos los WebElemets
	    PageFactory.initElements(driver, this);
	    
	}
	
	public LoginPage(WebDriver driver)
	{
		super("Login");
	    if (!driver.getTitle().equals("Welcome: Mercury Tours")) {
	        throw new IllegalStateException("This is not Correct Page," +
	              " current page is: " + driver.getCurrentUrl());
	      }
	    //Inicializamos los WebElemets
	    PageFactory.initElements(driver, this);
	    
	}
	
	public void iniciarSesion(String user, String pass)
	{
		esperaExplicita(txtUser,20);
		ingresarTexto(txtUser, user);
		ingresarTexto(txtPass,pass);
		clickBoton(btnLogin);
	}
	


}
