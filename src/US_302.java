import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_302 extends BaseDriver {

    @Test
    public void Test() {

        driver.navigate().to("https://shopdemo.fatfreeshop.com/?");

        WebElement addDemoEbookCart = driver.findElement(By.cssSelector("[onclick=\"return EJProductClick('1595015')\"]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(addDemoEbookCart)  //Clcik on Add to Cart Demo eBook
                .click()
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));

        WebElement isDemoAdded = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[1]/div[2]/div[2]"));
        Assert.assertTrue(isDemoAdded.isDisplayed(), "Demo ebook not added to cart");
        Assert.assertTrue(isDemoAdded.getText().contains("Demo eBook"), "Demo ebook not added to cart");
        actions.moveToElement(isDemoAdded).click().build().perform();

        WebElement click = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[2]/div[3]/div/button[3]"));
        click.click(); MyFunc.Bekle(1);

        WebElement eposta = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[2]/form/div[1]/p[1]/input"));
        eposta.sendKeys(""); MyFunc.Bekle(1);

        driver.switchTo().frame(1); //on EJIframev3 > 1st
        WebElement kartNo = driver.findElement(By.xpath("//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input"));
        kartNo.sendKeys(""); MyFunc.Bekle(1);

        driver.switchTo().parentFrame(); MyFunc.Bekle(1); // on parent EJIframev3

        WebElement Pay = driver.findElement((By.cssSelector("[class='Pay-Button']")));
        Pay.click(); MyFunc.Bekle(1);

        WebElement snackBar = driver.findElement(By.xpath("/html/body/div/div[2]/span"));
        System.out.println(snackBar.getText());
        Assert.assertTrue(snackBar.getText().contains("Invalid Email")&snackBar.getText().contains("Invalid Billing Name"),"Invalid names not displayed");

        MyFunc.Bekle(1);

//




    }
}
