package StepDefinitions;

import Pages.US_07SearchFunctionality_POM;
import Utilites.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_07SearchFunctionality {

    US_07SearchFunctionality_POM tab = new US_07SearchFunctionality_POM();

    @Given("the user logs into the Magento site")
    public void theUserLogsIntoTheMagentoSite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
        tab.myClick(tab.loginlink);
        tab.mySendKeys(tab.loginemail, "F@icloud.com"); // Test verisi
        tab.mySendKeys(tab.loginpassword, "Fatma123"); // Test verisi
        tab.myClick(tab.loginbutton);
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String SKU) {
        tab.myClick(tab.searchBar); // Arama çubuğuna tıkla
        tab.mySendKeys(tab.searchBar, SKU + Keys.ENTER); // SKU'yu yaz ve hemen ardından Enter tuşuna bas
    }

    @Then("the search results should display the product {string}")
    public void theSearchResultsShouldDisplayTheProduct(String expectedProductName) {
        // Arama sonuçlarının görünmesini bekle
        tab.wait.until(ExpectedConditions.visibilityOf(tab.productName)); // SKU öğesinin görünmesini bekle
        // Ürünün üzerine kaydır
        tab.scrolltoElement(tab.productName);
        String actualSKU = tab.productName.getText(); // SKU numarasını al

        // Beklenen SKU numarasının gerçekte görünen SKU numarasıyla karşılaştırılması
        if (actualSKU.equalsIgnoreCase(expectedProductName)) {
            System.out.println("SKU number matches: " + actualSKU);
        } else {
            throw new AssertionError("Expected SKU number: " + expectedProductName + ", but found: " + actualSKU);
        }
    }

    @When("the user follows the link {string}")
    public void theUserFollowsTheLink(String linkText) {

        switch (linkText) {
            case "Home":
                break;
            case "Men":
                tab.hoverAndOpenMenMenu(); // "Men" menüsüne hover yap
                break;
            case "Tops":
                tab.selectTops(); // "Tops" seçeneğine tıkla
                break;
            case "Jackets":
                tab.selectJackets(); // "Jackets" seçeneğine tıkla
                break;
            case "Home > Men > Tops > Jackets":
                tab.hoverAndOpenMenMenu(); // "Men" menüsüne hover yap
                tab.selectTops(); // "Tops" seçeneğine tıkla
                // JavaScript ile tıklama
                JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
                js.executeScript("arguments[0].click();", tab.jacketsOption);
                break;
            default:
                throw new IllegalArgumentException("Unknown link: " + linkText);
        }
    }

    @And("clicks on the product {string}")
    public void clicksOnTheProduct(String productName) {
        tab.myClick(tab.jacketClick);
    }

    @Then("the product page should show SKU number {string}")
    public void theProductPageShouldShowSKUNumber(String expectedSKU) {
        tab.verifySKU(expectedSKU); // SKU numarasını doğrula
    }

//    @When("the user decides to place an order for the product")[1 kere çalıştırılmalı sepete ürün ekleyince sepetteki ürün silinmeden 2. kez çalışmaz]
//    public void theUserDecidesToPlaceAnOrderForTheProduct() {
//        tab.scrollToAndClick(tab.size); // Boyuta kaydır ve tıkla
//        tab.scrollToAndClick(tab.color); // Renge kaydır ve tıkla
//        tab.scrollToAndClick(tab.addToCart); // Sepete ekle butonuna kaydır ve tıkla
//    }
}
