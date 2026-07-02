package com.tmobile.steps;
import com.tmobile.pages.CartPage;
import com.tmobile.pages.HomePage;
import com.tmobile.pages.ProductPage;
import com.tmobile.pages.ProductsListPage;
import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import org.testng.Assert;

public class ProductSelectionSteps {

    private String currentUrl;
    private String selectedProduct;
    private String productPrice;


    @Kiedy("Użytkownik przechodzi na stronę {string}")
    public void navigateToPage(String url) {
        Hooks.getDriver().get(url);
        this.currentUrl = url;
    }

    @Wtedy("Strona główna jest widoczna")
    public void verifyMainPageIsVisible() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        Assert.assertEquals(homePage.getCurrentUrl(), currentUrl, "Prawidłowa strona się nie wyświetla");
    }

    @Kiedy("Z górnej belki użytkownik wybiera \"Sklep\"")
    public void sklepSelect() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        homePage.acceptCookies();
        homePage.hoverOnSklep();
    }

    @Wtedy("Widoczna jest rozwijana lista menu")
    public void verifyListAppearance() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        Assert.assertTrue(homePage.istListDisplayed(), "Rozwijana lista nie pojawia się");
    }

    @Kiedy("Użytkownik klika \"Bez abonamentu\" z sekcji \"Smartfony\"")
    public void noSubscriptionSelect() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        homePage.clickOnNoSubscriptionButton();
    }

    @Wtedy("Widoczna jest lista smartfonów")
    public void verifySmartphoneListAppearance() {
        ProductsListPage productsListPage = new ProductsListPage(Hooks.getDriver());
        Assert.assertTrue(productsListPage.getProductsGrid().isDisplayed(), "Lista smartfonów nie pojawia się");
    }

    @Kiedy("Użytkownik klika element z listy o nazwie {string}")
    public void productSelectByName(String product) {
        ProductsListPage productsListPage = new ProductsListPage(Hooks.getDriver());
        productsListPage.productSelect(product);
        this.selectedProduct = product;
    }

    @Wtedy("Widoczna jest strona produktu")
    public void verifyProductTitleAndPrice() {
        ProductPage productPage = new ProductPage(Hooks.getDriver());
        Assert.assertEquals(productPage.getProductTitle(), selectedProduct, "Strona produktu nie jest widoczna");
        this.productPrice = productPage.getProductPrice();
    }

    @Kiedy("Użytkownik klika \"Dodaj do koszyka\"")
    public void addToCartClick() {
        ProductPage productPage = new ProductPage(Hooks.getDriver());
        productPage.addToCartButtonClick();
    }

    @Wtedy("Widoczna jest strona koszyka, a cena zgadza się z ceną z produktu")
    public void verifyBasketAndProductPrice() {
        CartPage cartPage = new CartPage(Hooks.getDriver());
        Assert.assertEquals(cartPage.getProductPrice(), productPrice, "Ceny nie zgadzają się");
        Assert.assertEquals(cartPage.getBasketHeaderText(), "Twój koszyk", "Strona Twój Koszyk nie wyświetla się");
    }

    @Kiedy("Użytkownik przechodzi z powrotem na stronę główną T-Mobile")
    public void mainPageNavigation() {
        CartPage cartPage = new CartPage(Hooks.getDriver());
        cartPage.logoIconClick();
    }

    @Wtedy("Użytkownik wraca na stronę główną")
    public void verifyUserReturnedToMainPage() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        Assert.assertTrue(homePage.isSklepButtonDisplayed(), "Strona główna nie pojawiła sie");
    }

    @Kiedy("Użytkownik klika \"Koszyk\"")
    public void basketSelect() {
        HomePage homePage = new HomePage(Hooks.getDriver());
        homePage.basketClick();
    }

    @Wtedy("Widoczna jest strona koszyka, a koszyk zawiera dodane urządzenie")
    public void verifyProductTitleAndBasketHeader() {
        CartPage cartPage = new CartPage(Hooks.getDriver());
        Assert.assertEquals(cartPage.productTitleName(), selectedProduct, "Koszyk nie zawiera nazwy dodanego urządzenia");
        Assert.assertTrue(cartPage.isBasketHeaderDisplayed(), "Strona koszyka nie pojawiła się");
    }


}
