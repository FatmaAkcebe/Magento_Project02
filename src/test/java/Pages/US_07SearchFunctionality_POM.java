package Pages;

import Utilites.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_07SearchFunctionality_POM extends ParentPage {

    public US_07SearchFunctionality_POM() { PageFactory.initElements(GWD.getDriver(), this);}

    //LOGİN
    @FindBy(xpath = "//li[@class='authorization-link']/a")
    public WebElement loginlink;

    @FindBy(css = "[id='email']")
    public WebElement loginemail;

    @FindBy(id= "pass")
    public WebElement loginpassword;

    @FindBy(id="send2")
    public WebElement loginbutton;

    //US7
    @FindBy(id = "search")
    public WebElement searchBar;

    @FindBy(css = "[class='product-item-link']")
    public WebElement productName;

    // "Men" menüsü için WebElement
    @FindBy(xpath = "//span[text()='Men']")
    public WebElement menMenu;

    // "Tops" alt menüsü için WebElement
    @FindBy(xpath = "//a[@id='ui-id-17']")
    public WebElement topsOption;

    // "Jackets" alt menüsü için WebElement
    @FindBy(xpath = "//a[@id='ui-id-19']")
    public WebElement jacketsOption;

    @FindBy(xpath = "//a[contains(text(), 'Lando Gym Jacket')]")
    public WebElement jacketClick;

    @FindBy(xpath = "//div[@itemprop='sku']")
    public WebElement skuElement;

    //Sepete ekleme(size,color)
    @FindBy(xpath = "//button[@title='Add to Cart']")
    public WebElement addToCart;

    @FindBy(id = "option-label-size-143-item-166")
    public WebElement size;

    @FindBy(id = "option-label-color-93-item-50")
    public WebElement color;


    // Menüye hover yapma ve alt seçenekleri gösterme metodu
    public void hoverAndOpenMenMenu() {
        Actions aksiyonlar = new Actions(GWD.getDriver());
        aksiyonlar.moveToElement(menMenu).perform(); // "Men" menüsüne hover yap
    }

    // "Tops" seçeneğine tıklama metodu
    public void selectTops() {
        Actions aksiyonlar = new Actions(GWD.getDriver());
        aksiyonlar.moveToElement(topsOption).click().perform(); // "Tops" seçeneğine tıkla
    }

    // "Jackets" seçeneğine tıklama metodu
    public void selectJackets() {
        hoverAndOpenMenMenu(); // "Men" menüsüne hover yap
        selectTops(); // "Tops" seçeneğine tıkla

        // Menü açılmasını bekleyin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("submenu"))); // Alt menünün görünmesini bekle
        wait.until(ExpectedConditions.visibilityOf(jacketsOption)); // "Jackets" seçeneğinin görünmesini bekle

        // "Jackets" seçeneğine tıklayın
        jacketsOption.click();
    }
    //     SKU kontrol metodu
    public void verifySKU(String expectedSKU) {
        // SKU'yu doğrula
        LoginContainsText(skuElement, expectedSKU);

        // Konsola SKU numarasını yazdır
        System.out.println("SKU Number: " + expectedSKU);
    }

}
