package com.tmobile.pages;

import com.tmobile.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1[data-qa='PRD_ProductName']")
    private WebElement productTitle;

    @FindBy(xpath = "//span[contains(@class, 'actualText')]")
    private WebElement productPrice;

    public String getProductTitle() {
        SeleniumHelper.elementVisible(driver, productTitle);
        return productTitle.getText();
    }

    public String getProductPrice() {
        SeleniumHelper.elementVisible(driver, productPrice);
        return productPrice.getText();
    }

    public CartPage addToCartButtonClick() {
        SeleniumHelper.clickFirstDisplayedElement(driver, By.cssSelector("button[data-qa='PRD_AddToBasket']"));
        return new CartPage(driver);
    }
}
