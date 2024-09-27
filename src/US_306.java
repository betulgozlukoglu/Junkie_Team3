import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;

public class US_306 extends BaseDriver {



    @Test
    public void Test1() throws AWTException {

        driver.get("https://shopdemo.fatfreeshop.com/");



        WebElement ContactUs=driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/a"));
        new Actions(driver)
                .moveToElement(ContactUs)
                .click()
                .build()
                .perform();
        MyFunc.Bekle(2);




        WebElement Name=driver.findElement(By.xpath("//*[@id=\"sender_name\"]"));
        new Actions(driver)
                .moveToElement(Name)
                .click()
                .sendKeys("jondoe")
                .build()
                .perform();
        MyFunc.Bekle(2);




        WebElement Email=driver.findElement(By.xpath("//*[@id=\"sender_email\"]"));
        new Actions(driver)
                .moveToElement(Email)
                .click()
                .sendKeys("i.doe@test.com")
                .build()
                .perform();
        MyFunc.Bekle(2);



        WebElement Subject=driver.findElement(By.xpath("//*[@id=\"sender_subject\"]"));
        new Actions(driver)
                .moveToElement(Subject)
                .click()
                .sendKeys("blabla")
                .build()
                .perform();
        MyFunc.Bekle(2);



        WebElement Message=driver.findElement(By.xpath("//*[@id=\"sender_message\"]"));
        new Actions(driver)
                .moveToElement(Message)
                .click()
                .sendKeys("blablablablablablablablablablablablablablablablablabla")
                .build()
                .perform();
        MyFunc.Bekle(2);



        WebElement SendMessage=driver.findElement(By.xpath("//*[@id=\"send_message_button\"]"));
        new Actions(driver)
                .moveToElement(SendMessage)
                .click()
                .build()
                .perform();
        MyFunc.Bekle(2);



        }


    }
