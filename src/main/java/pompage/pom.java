package pompage;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.DocFlavor;

public class pom {
    public WebDriver driver;
    public pom(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public By myaccount =  org.openqa.selenium.By.cssSelector(".list-inline>li:nth-child(2)>a");

    @FindBy(css =".dropdown-menu.dropdown-menu-right>li:nth-child(2)>a")
    public WebElement login;

    public By email =org.openqa.selenium.By.cssSelector(".form-group>input[id='input-email']");

    @FindBy(css =".form-group>input[id='input-password']")
    public WebElement password;
    @FindBy(xpath ="//input[@value='Login']")
    public WebElement loginbtn;

    public By myact = org.openqa.selenium.By.cssSelector("#content>h2:nth-child(1)");

    @FindBy(css=".dropdown-menu.dropdown-menu-right>li:nth-child(5)")
    public WebElement logout;

    @FindBy(css=".nav.navbar-nav>li:nth-child(7)>a")
    public WebElement camera;

    @FindBy(css=".caption>h4>a[href='https://awesomeqa.com/ui/index.php?route=product/product&path=33&product_id=30']")
    public WebElement canon;

    @FindBy(xpath = "(//span[.='Add to Cart'])[1]")
    public WebElement addcart1;

    public By availopt=org.openqa.selenium.By.cssSelector("#input-option226");

    @FindBy(css=".form-group>button[id='button-cart']")
    public WebElement addcart;

    public By response=By.cssSelector(".alert.alert-success.alert-dismissible");
    public By shopingcart=By.cssSelector(".alert.alert-success.alert-dismissible>a:nth-child(2)");
    public By addcartverify=By.cssSelector(".table-responsive>table>tbody>tr>td:nth-child(2)>a");










}
