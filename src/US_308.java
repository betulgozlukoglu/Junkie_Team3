import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_308 extends BaseDriver {
    @Test
    public void test1() {
        driver.get("https://www.e-junkie.com/ ");
        MyFunc.Bekle(2);


        WebElement SeeHowWorks=driver.findElement(By.xpath("//a[@class='blue_btn']"));
        SeeHowWorks.click();
        MyFunc.Bekle(2);

        Assert.assertTrue( driver.getCurrentUrl().equals("https://www.e-junkie.com/")," Yanlış Url ");

        MyFunc.Bekle(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(200, 100).click();");


        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(iframe);


        WebElement oynat=driver.findElement(By.cssSelector(".ytp-large-play-button"));
        oynat.click();

        MyFunc.Bekle(10);
        BekleKapat();

    }

}
