package com.tmobile.pages;

import com.tmobile.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Sklep']")
    private WebElement sklepButton;

    @FindBy(xpath = "//a[text()='Bez abonamentu']")
    private WebElement smartfonBezAbonamentuButton;

    @FindBy(css = "a[href='https://www.t-mobile.pl/sklep/basket']")
    private WebElement koszykButton;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement acceptCoockiesButton;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage hoverOnSklep() {
        Actions actions = new Actions(driver);
        SeleniumHelper.elementVisible(driver, sklepButton);
        actions.moveToElement(sklepButton).perform();
        return this;
    }

    public boolean isSklepButtonDisplayed() {
        SeleniumHelper.elementVisible(driver, sklepButton);
        return sklepButton.isDisplayed();
    }

    public boolean istListDisplayed() {
        return smartfonBezAbonamentuButton.isDisplayed();
    }

    public HomePage acceptCookies() {
        SeleniumHelper.elementVisible(driver, acceptCoockiesButton);
        acceptCoockiesButton.click();
        return this;
    }

    public ProductsListPage clickOnNoSubscriptionButton() {
        SeleniumHelper.clickWhenVisible(driver, smartfonBezAbonamentuButton);
        return new ProductsListPage(driver);
    }

    public CartPage basketClick() {
        SeleniumHelper.clickWhenVisible(driver, koszykButton);
        return new CartPage(driver);
    }
}
