package com.tmobile.pages;

import com.tmobile.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {

    WebDriver driver;

    public ProductsListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dyt_productsGrid")
    private WebElement productsGrid;

    public WebElement getProductsGrid() {
        return productsGrid;
    }

    public ProductPage productSelect(String product) {
        String xpath = String.format("//a[contains(@aria-label, '%s')]", product);
        SeleniumHelper.clickWhenVisible(driver, By.xpath(xpath));
        return new ProductPage(driver);
    }

}
