import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_304 extends BaseDriver {

    @Test
    public void Test4() {
        driver.get("https://shopdemo.fatfreeshop.com/?");


        WebElement addcart = driver.findElement(By.xpath("//div[@id='EJProduct_1597355']/.."));
        addcart.click();


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='g_btn']")));
        WebElement scroll = driver.findElement(By.cssSelector("[class='g_btn']"));
        new Actions(driver)
                .scrollToElement(scroll)
                .build()
                .perform();

        WebElement click = driver.findElement(By.cssSelector("[class='g_btn']"));
        new Actions(driver)
                .moveToElement(click)
                .click()
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='EJIframeV3 EJOverlayV3']")));
        WebElement frame = driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='Shipping-Section-Postcode']")));

        WebElement postalCode = driver.findElement(By.cssSelector("[class='Shipping-Section-Postcode']"));
        postalCode.sendKeys("ct-123");


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Visa, AMEX, MasterCard, Maestro, Discover']")));
        WebElement creditCard = driver.findElement(By.xpath("//span[text()='Visa, AMEX, MasterCard, Maestro, Discover']"));
        creditCard.click();
        creditCard.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Email']")));
        WebElement email = driver.findElement(By.cssSelector("[placeholder='Email']"));
        new Actions(driver)
                .moveToElement(email)
                .click()
                .sendKeys("technoStudy@gmail.com")
                .build().perform();

        WebElement emailconfirm = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        new Actions(driver)
                .moveToElement(emailconfirm)
                .click()
                .sendKeys("technoStudy@gmail.com")
                .build().perform();

        WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        new Actions(driver)
                .moveToElement(nameOnCard)
                .click()
                .sendKeys("Yusuf")
                .build().perform();

        WebElement phone = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[1]"));
        phone.sendKeys("0521 221 21 21");

        WebElement company = driver.findElement(By.xpath("(//input[@autocomplete='company'])[1]"));
        new Actions(driver)
                .moveToElement(company)
                .click()
                .sendKeys("TechnoStudy")
                .build().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Address Line 1'])[2]")));
        WebElement adressLine1 = driver.findElement(By.xpath("(//input[@autocomplete='address-1'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Dunyadan Bir Yer';", adressLine1);


        WebElement cityy = driver.findElement(By.xpath("(//input[@placeholder='City' and @autocomplete='city'])[2]"));
        new Actions(driver)
                .moveToElement(cityy)
                .click()
                .sendKeys("Antalya")
                .build().perform();

        WebElement state = driver.findElement(By.xpath("(//input[@autocomplete='state'])[2]"));
        new Actions(driver)
                .moveToElement(state)
                .click()
                .sendKeys("Bilinmez")
                .build().perform();


        driver.switchTo().frame(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Kart numarası']")));
        WebElement karrt = driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));

        karrt.sendKeys("4242 4242 4242 4242");

        WebElement dateofCard = driver.findElement(By.cssSelector("[autocomplete='cc-exp']:nth-child(1)"));
        dateofCard.sendKeys("1224");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='InputContainer'])[3]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='InputContainer'])[3]")));
        WebElement cvvv = driver.findElement(By.xpath("(//span[@class='InputContainer'])[3]"));
        new Actions(driver)
                .moveToElement(cvvv)
                .click()
                .sendKeys("000")
                .build().perform();

        driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Pay-Button']")));
        WebElement payy = driver.findElement(By.cssSelector("[class='Pay-Button']"));
        payy.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='green_text_margin']")));
        WebElement message = driver.findElement(By.cssSelector("[class='green_text_margin']"));
        Assert.assertTrue(message.isDisplayed(), "sayfa bulunamadi");
        System.out.println("Result Mesaage = " + "Yusuf " + "," + message.getText());
        BekleKapat();
    }
}









