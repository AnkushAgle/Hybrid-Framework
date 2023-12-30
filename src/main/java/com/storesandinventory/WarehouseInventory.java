package com.storesandinventory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WarehouseInventory {
	//span[text()='Stores & Inventory']
	
	@FindBy(how=How.XPATH,using="//span[text()='Stores & Inventory']")
	private WebElement StoresInventory;
	//a[text()='Warehouse Inventory']
	@FindBy(how=How.XPATH,using="//a[text()='Warehouse Inventory']")
	private WebElement WarehouseInventory;
	//button[normalize-space()='Edit']
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Edit']")
	private WebElement Editbtn;
	//a[@id='tb-itemwise']
	
	@FindBy(how=How.XPATH,using="//a[@id='tb-itemwise']")
	private WebElement itemwise;
	
	//button[@class='btn btn-outline-secondary btn-search border-0']
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-outline-secondary btn-search border-0']")
	private WebElement itemsearchbtn;
	
	//a[text()='Next']
	@FindBy(how=How.XPATH,using="//a[text()='Next']")
	private WebElement itemsearchNextbtn;
	
	public WebElement getitemsearchNextbtn() {
		return itemsearchNextbtn;
	}
	public WebElement getStoresInventory() {
		return StoresInventory;
	}

	public WebElement getWarehouseInventory() {
		return WarehouseInventory;
	}

	public WebElement getEditbtn() {
		return Editbtn;
	}

	public WebElement getItemwise() {
		return itemwise;
	}

	public WebElement getItemsearchbtn() {
		return itemsearchbtn;
	}

	
}
