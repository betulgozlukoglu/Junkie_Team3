import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class US_307 extends BaseDriver {

    @Test
    public void Test() throws InterruptedException {
        // E-Junkie ana sayfasına git
        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);

        // Sayfanın en altına kaydır
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.END);
        MyFunc.Bekle(2);
        System.out.println("Sayfa en alta kaydırıldı.");

        // "E-Commerce by E-Junkie" linkinin görünür olduğunu doğrula

        WebElement eCommercelink=driver.findElement(By.linkText("E-commerce by E-junkie"));
        eCommercelink.click();
        System.out.println("E-Commerce by E-Junkie linki görünüyor. tıklandı");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/wiki/user/themes/Wiki/images/logo.svg?123']")));
        assertTrue(logo.isDisplayed(),"logo görünmüyor");
        logo.click();
        System.out.println("Logo görüldü, tıklandı.");

        MyFunc.Bekle(2);

        // Sayfanın doğru yüklendiğini doğrula

        if (driver.getTitle().equals("Sell Downloads | E-junkie")) {
            System.out.println("Ana sayfa başarıyla yüklendi.");
        } else
            Assert.assertEquals(driver.getTitle(), "Sell Downloads | E-junkie", "Ana sayfa yüklenemedi.");

        driver.quit();

    }
}
