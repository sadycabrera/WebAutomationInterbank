package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	//variable
	@FindBy(how = How.XPATH, using = "//h3")
	private WebElement txtMensajeExito;
	
	public HomePage()
	{
		super("Home");
		PageFactory.initElements(driver, this);
	}
	
	public String getMensajeExito()
	{
		return txtMensajeExito.getText();
	}

}
