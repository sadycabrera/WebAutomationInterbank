package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{

	@FindBy(how = How.XPATH, using = "//span")
	private WebElement txtMensajeError;
	
	public IndexPage() {
		super("Index");
		PageFactory.initElements(driver, this);
	}
	
	public String getMensajeError()
	{
		return txtMensajeError.getText();
	}
	

}
