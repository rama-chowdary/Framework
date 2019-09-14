package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.OR;

public class LaunchPage {
	@FindBy(id = OR.ebaySrchBoxObject)
	WebElement ebaySrchBoxObject;

	@FindBy(id = OR.ebayDropDownObject)
	WebElement ebayDropDownObject;

	@FindBy(id = OR.ebaySrchButtonObject)
	WebElement ebaySrchButtonObject;

	public void enterTextIntoEbaySrchBox(String data) {
		ebaySrchBoxObject.sendKeys(data);
	}

	public void selectItemFromEbayDropDown(String data) {
		Select sel = new Select(ebayDropDownObject);
		sel.selectByVisibleText(data);

	}

	public void clickEbaySrchBtn() {
		ebaySrchButtonObject.click();
	}

}
