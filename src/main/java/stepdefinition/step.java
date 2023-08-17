package stepdefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pompage.pom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class step {
public  WebDriver driver;
public  pom po;
public WebDriverWait wait;
    @Given("user open the browser and pass the url {string}")
    public void user_open_the_browser_and_pass_the_url(String url) {
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver(opt);
         driver.get(url);
          po=new pom(driver);
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
         // driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
         wait=new WebDriverWait(driver,Duration.ofMinutes(1));
    }
    @When("user click on my account and click on login")
    public void user_click_on_my_account_and_click_on_login() {
        wait.until(ExpectedConditions.elementToBeClickable(po.myaccount)).click();
        po.login.click();

    }
    @When("^pass Uname (.*) Password (.*)$")
    public void pass_uname_deekshithgowda9897_gmail_com_password_blackfield(String uname,String pwd) {
wait.until(ExpectedConditions.visibilityOfElementLocated(po.email)).sendKeys(uname);
po.password.sendKeys(pwd);
    }
    @When("click on login button")
    public void click_on_login_button() {

        po.loginbtn.click();
    }
    @Then("validate user is on myaccount page")
    public void validate_user_is_on_myaccount_page() throws IOException {
        //String str = wait.until(ExpectedConditions.presenceOfElementLocated(po.myact)).getText();
        if(driver.getCurrentUrl().contains("https://awesomeqa.com/ui/index.php?route=account/account"))
        {
            System.out.println("tc pass");
            wait.until(ExpectedConditions.elementToBeClickable(po.myaccount)).click();
            po.logout.click();
            driver.close();
        }
        else
        {
            FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File("C:\\Users\\deekshith.gowda\\Favorites\\intelijpractice\\opencart\\src\\screensot\\opencart"+System.currentTimeMillis()+".jpeg"));
            System.out.println("tc fail");
            driver.quit();
        }

    }
    @When("login with username {string} and password {string}")
    public void login_with_username_and_password(String uname, String pwd) {
        wait.until(ExpectedConditions.elementToBeClickable(po.myaccount)).click();
        po.login.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(po.email)).sendKeys(uname);
        po.password.sendKeys(pwd);
    }
    @When("mousehover on camera and click and select the item {string}")
    public void mousehover_on_camera_and_click_and_select_the_item(String pname) {
        wait.until(ExpectedConditions.elementToBeClickable(po.camera)).click();
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".caption>h4 >a")));
        for(WebElement prod:products)
        {
            if(prod.getText().equalsIgnoreCase(pname))
            {
                prod.click();
                break;
            }
        }

       // wait.until(ExpectedConditions.elementToBeClickable(po.canon)).click();

    }
    @When("select the avilable options")
    public void select_the_avilable_options() {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(po.availopt));
        Select sel=new Select(ele);
        sel.selectByIndex(1);
    }
    @When("click on add to cart")
    public void click_on_add_to_cart() {
       po.addcart.click();
    }
    @Then("verify valid product is added in shopping cart")
    public void verify_valid_product_is_added_in_shopping_cart() {
        String addcarttext = wait.until(ExpectedConditions.visibilityOfElementLocated(po.response)).getText();
        System.out.println(addcarttext);
        driver.findElement(po.shopingcart).click();
        String orginalitem = wait.until(ExpectedConditions.visibilityOfElementLocated(po.addcartverify)).getText();
        if(orginalitem.contains("Canon EOS 5D"))
        {
            System.out.println("Tc pass");
        }

        else
        {
            System.out.println("tc fail");
        }


    }

}
