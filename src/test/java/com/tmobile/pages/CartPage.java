package com.tmobile.pages;

import com.tmobile.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".basketHeaderText")
    private WebElement basketHeader;

    @FindBy(css = "span[data-qa='BKT_Activation']")
    private WebElement productPrice;

    @FindBy(css = ".logo-panel")
    private WebElement logoIcon;

    @FindBy(xpath = "//div[@data-qa='BKT_ItemTitle0']//h3")
    private WebElement productTitle;

    public String getBasketHeaderText() {
        SeleniumHelper.elementVisible(driver, basketHeader);
        return basketHeader.getText();
    }

    public boolean isBasketHeaderDisplayed() {
        SeleniumHelper.elementVisible(driver, basketHeader);
        return basketHeader.isDisplayed();
    }

    public String getProductPrice() {
        SeleniumHelper.elementVisible(driver, productPrice);
        return productPrice.getText();
    }

    public HomePage logoIconClick() {
        SeleniumHelper.clickWhenVisible(driver, logoIcon);
        return new HomePage(driver);
    }

    public String productTitleName() {
        SeleniumHelper.elementVisible(driver, productPrice);
        return productTitle.getText();
    }

}
