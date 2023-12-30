package com.material;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ITMMSTEDIT {
	

	@FindBy(how=How.XPATH,using="//div[@title='next']")
	private WebElement NextButton;

}
