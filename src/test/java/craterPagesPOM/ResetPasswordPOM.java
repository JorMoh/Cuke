package craterPagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class ResetPasswordPOM {
	
	public ResetPasswordPOM() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//div[text()='Send Reset Link']")
	public WebElement sendResetLinkBtn;	
	
	@FindBy(xpath = "//input[@name ='email']")
	public WebElement enterEmailField;	
	
	@FindBy(xpath = "//span[text()='Incorrect Email.']")
	public WebElement incorrectEmailText;	
	
	@FindBy(xpath = "//span[text()='Field is required']")
	public WebElement fieldisRequiredText;	
	
	@FindBy(xpath = "//p[text()='Mail sent successfully']")
	public WebElement mailSentsSuccessMessage;	
	
	@FindBy(linkText = "Back to Login?")
	public WebElement backToLoginLink;	
	
	

}
