package craterPagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CustomersPOM {
	public CustomersPOM() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//ADD CUSTOMER
	@FindBy(xpath = "//button[text()= ' New Customer']")
	public WebElement addNewCustomerBtn;
	
	@FindBy(xpath = "//h3[text()= 'New Customer']")
	public WebElement newCustomerHeader;
	
	@FindBy(xpath = "(//input[@name= 'name'])[1]")
	public WebElement basicInfoDisplayName;
	
	@FindBy(xpath = "//input[@name= 'email']")
	public WebElement basicInfoEmail;
	
	@FindBy(xpath = "(//input[@name= 'phone'])[1]")
	public WebElement basicInfoPhone;
	
	@FindBy(xpath = "//span[@class='translate-x-1 inline-block w-4 h-4 transition-transform bg-white rounded-full']")
	public WebElement portalAccess;
	
	@FindBy(xpath = "(//input[@name= 'address_name'])[1]")
	public WebElement billingAddressName;
	
	@FindBy(xpath = "(//input[@class='w-full absolute inset-0 outline-none appearance-none box-border border-0 text-sm "
			+ "font-sans bg-white rounded-md pl-3.5'])[2]")
	public WebElement billingAddressCountry;
	
	@FindBy(xpath = "//input[@name= 'billing.state']")
	public WebElement billingAddressState;
	
	@FindBy(xpath = "//input[@name= 'billing.city']")
	public WebElement billingAddressCity;
	
	@FindBy(xpath = "//textarea[@name= 'billing_street1']")
	public WebElement billingAddressStreet1;
	
	@FindBy(xpath = "//button[text()=' Copy from Billing']")
	public WebElement copyFromBillingBtn;
	
	@FindBy(xpath = "//div[@class='flex items-center justify-end']")
	public WebElement saveCustomerBtn;
	
	@FindBy(xpath = "//p[@class='text-sm leading-5 font-medium text-gray-900']")
	public WebElement successfulCustomerCreationMsg;
	
	@FindBy(xpath = "//p[text()='Customer created successfully']")
	public WebElement successfulCustomerCreationMsgCloseBtn;
	
	//CUSTOMER INFO
	@FindBy(xpath = "//h6[@class='flex items-center']")
	public WebElement salesAndExpensesHeader;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[1]")
	public WebElement customerPageDisplayName;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[3]")
	public WebElement customerPageEmail;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[4]")
	public WebElement customerPageCurrency;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[5]")
	public WebElement customerPagePhone;
	
	//EDIT CUSTOMER
	@FindBy(xpath="(//button[@type='button'])[3]")
    public WebElement threeDotsBtn;
	
	@FindBy(xpath="//a[text()=' Edit']")
	public WebElement ItemEditBtn;
	
	@FindBy(xpath="//h3[text()='Edit Customer']")
	public WebElement editCustomerHeader;
	
	@FindBy(xpath="//h6[text()='Basic Info']")
	public WebElement editBasicInfoHeader;
	
	@FindBy(xpath="//div[text()='Display Name ']")
	public WebElement editDisplayNameLabel;
	
	@FindBy(xpath="//div[text()='Email ']")
	public WebElement editEmailLabel;
	
	@FindBy(xpath="//div[text()='Phone ']")
	public WebElement editPhoneLabel;
	
	@FindBy(xpath="//div[text()='Primary Currency ']")
	public WebElement editPrimaryCurrencyLabel;
	
	@FindBy(xpath="//h6[text()='Portal Access']")
	public WebElement editPortalAccessHeader;
	
	@FindBy(xpath="//h6[text()='Billing Address']")
	public WebElement billingAddressHeader;
	
	@FindBy(xpath="//div[text()='Name ']")
	public WebElement billingAddressNameLabel;
	
	@FindBy(xpath="//div[text()='Country ']")
	public WebElement billingAddressCountryLabel;
	
	@FindBy(xpath="//div[text()='State ']")
	public WebElement billingAddressStateLabel;
	
	@FindBy(xpath="//div[text()='City ']")
	public WebElement billingAddressCityLabel;
	
	@FindBy(xpath="//div[text()='Address ']")
	public WebElement billingAddressStreet1Label;

	@FindBy(xpath="//div[@class='flex items-center justify-end']")
	public WebElement updateCustomerBtn;
	
	@FindBy(xpath = "//p[@class='text-sm leading-5 font-medium text-gray-900']")
	public WebElement successfulCustomerUpdateMsg;
	
	//DELET CUSTOMER
	
	@FindBy(xpath="//a[text()=' Delete']")
	public WebElement customerDeleteBtn;
	
	@FindBy(xpath = "//p[@class='text-sm leading-5 font-medium text-gray-900']")
	public WebElement successfulCustomerDeleteMsg;
	
	@FindBy(xpath="//button[text()='Cancel']")
	public WebElement deleteOkButton;
	
	@FindBy(xpath="//button[text()='Ok']")
	public WebElement deleteCancelButton;
	
	@FindBy(xpath="//h3[text()='Are you sure?']")
	public WebElement modalTitle;
	
	@FindBy(xpath="//p[text()='You will not be able to recover this customer and"
			+ " all the related Invoices, Estimates and Payments.']")
	public WebElement modalMessage;
	
	
	
	
	

}
