package Pages;

import Utilites.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_08WishList_POM extends ParentPage {
    public US_08WishList_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    //US8
    // "Women" menüsü için WebElement
    @FindBy(xpath = "//span[text()='Women']")
    public WebElement womenMenu;

    // "Tops" alt menüsü için WebElement
    @FindBy(xpath = "//a[@id='ui-id-9']")
    public WebElement topsOption2;

    //ürüne tıklama
    @FindBy(xpath = "//a[contains(text(), 'Breathe-Easy Tank')]")
    public WebElement TunicClick;


    //fovorilere ekleme
    @FindBy(xpath = "//div[@class='product-addto-links']/a[@class='action towishlist'][1]")
    public WebElement wishList;


    //başarı messajı
    @FindBy(xpath = "//div[contains(@data-bind, 'html: $parent.prepareMessageForHtml')]")
    public WebElement message2;



    //SİLİNME MESAJI
    @FindBy(xpath = "//div[@class='message info empty']/span")
    public WebElement emptyMessage ;

    // Menüye hover yapma ve alt seçenekleri gösterme metodu
    public void hoverAndOpenMenMenu2() {
        Actions aksiyonlar = new Actions(GWD.getDriver());
        aksiyonlar.moveToElement(womenMenu).perform(); // "women" menüsüne hover yap
    }

    // "Tops" seçeneğine tıklama metodu
    public void selectTops2() {
        Actions aksiyonlar = new Actions(GWD.getDriver());
        aksiyonlar.moveToElement(topsOption2).click().perform(); // "Tops" seçeneğine tıkla
    }

    public WebElement getRemoveFromWishlistButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-role='remove']")));}

    // Metotlar
    public void checkEmptyMessage() {
        // Mesajı al
        String actualMessage = emptyMessage.getText().trim();
        String expectedMessage = "You have no items in your wish list."; // Beklenen tam mesaj
        // Mesajı doğrula
        Assert.assertEquals(actualMessage, expectedMessage);
        // Konsola yazdır
        System.out.println("Mesaj görüntüleniyor: " + actualMessage);}

    public void clickButton(String buttonName) {
        WebElement buttonToClick = null;

        switch (buttonName.toLowerCase()) {
            case "add to wishlist":
                buttonToClick = wishList;
                break;
            case "remove from wishlist":
                buttonToClick = getRemoveFromWishlistButton();
                break;
            default:
                Assert.fail("Button name not recognized: " + buttonName);
        }

        // JavaScript ile tıklama
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", buttonToClick);
    }
}
