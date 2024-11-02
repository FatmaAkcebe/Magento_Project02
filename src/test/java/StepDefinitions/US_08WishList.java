package StepDefinitions;

import Pages.US_08WishList_POM;
import Utilites.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class US_08WishList {

    US_08WishList_POM tab = new US_08WishList_POM();

    @And("navigates to the page of a product they like")
    public void navigatesToThePageOfAProductTheyLike() {
        tab.hoverAndOpenMenMenu2(); // "Women" menüsüne hover yap
        tab.selectTops2(); // "Tops" seçeneğine tıkla
        tab.myClick(tab.TunicClick);// "Breathe-Easy Tank" ürününe tıkla
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        tab.clickButton(buttonName);
    }

    @Then("a message indicating that the product has been added to the wishlist is displayed")
    public void aMessageIndicatingThatTheProductHasBeenAddedToTheWishlistIsDisplayed() {
        String expectedMessage = "has been added"; // Beklenen mesajın bir parçası
        tab.LoginContainsText(tab.message2, expectedMessage); // Mesajı doğrulamak için LoginContainsText metodunu çağır
        // Mesajı konsola yazdır
        String actualMessage = tab.message2.getText();
        System.out.println("Displayed Message: " + actualMessage);
    }


    @Then("they see the remove icon")
    public void theySeeTheRemoveIcon() {
        // Kaldır düğmesini görüntülemek için ürünün üzerine gelme
        Actions actions = new Actions(GWD.getDriver());
        actions.moveToElement(tab.TunicClick).perform(); //İmleci ürünün üzerine getirme
    }

    @Then("a message indicating that the product has been removed from the wishlist is displayed")
    public void aMessageIndicatingThatTheProductHasBeenRemovedFromTheWishlistIsDisplayed() {
        String expectedMessage = "You have no items in your wish list."; // Beklenen boş fovorilerim mesajı
        // Opsiyonel olarak, hata ayıklama için gerçek mesajı yazdır
        String actualMessage = tab.emptyMessage.getText().trim();
        System.out.println("Silme sonrası mesaj: " + actualMessage);


    }
}
