import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utility.BaseDriver.wait;

public class US_301 extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("//h4[text()='Demo eBook']/../button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Demo eBook']")));
        WebElement AddPromo = driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        AddPromo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Actions']//input")));
        WebElement promoCode = driver.findElement(By.xpath("//div[@class='Actions']//input"));
        promoCode.sendKeys("1234");

        WebElement apply = driver.findElement(By.xpath("//div[@class='Actions']//button[text()='Apply']"));
        apply.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='close-circle']/following-sibling::span")));
        WebElement msg = driver.findElement(By.xpath("//*[@name='close-circle']/following-sibling::span"));
        Assert.assertTrue(msg.isDisplayed(),"Mesaj görüntülenemedi");

        BekleKapat();


    }

}
