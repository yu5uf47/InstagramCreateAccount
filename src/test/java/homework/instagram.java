package homework;

import com.github.javafaker.Faker;
import dev.failsafe.internal.util.Durations;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class instagram extends TestBase {


Faker faker= new Faker();
Select select;


/*
    @Test
    public void fakeMaillll() {

        driver.get("https://www.fakemail.net/");
        driver.findElement(By.xpath("//*[@href='/delete']")).click();

        driver.navigate().refresh();
        // WebElement copy=driver.findElement(By.xpath("//*[@id='email']"));
        WebElement copy=driver.findElement(By.id("email"));
        copy.click();
        System.out.println("copy.getText() = " + copy.getText());

    }

 */

    @Test
    public void giris() {
        driver.get("https://www.instagram.com");
        String instagramhan= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.fakemail.net/");
        String fakemailhan= driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@href='/delete']")).click();

        driver.navigate().refresh();
        // WebElement copy=driver.findElement(By.xpath("//*[@id='email']"));
        String copy=driver.findElement(By.id("email")).getText();


        driver.switchTo().window(instagramhan);
        driver.findElement(By.xpath("//span[contains(@class,'aad7')]")).click();
        //driver.findElement(By.xpath("(//*[@dir='auto'])[2]")).click();
        WebElement email= driver.findElement(By.xpath("//*[@name='emailOrPhone']"));
        email.click();
        email.sendKeys(copy
                , Keys.TAB,
                faker.name().fullName(),Keys.TAB,
                faker.name().username()+"47",Keys.TAB,
                faker.internet().password());

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement ay= driver.findElement(By.xpath("//*[@title='Ay:']"));
        select=new Select(ay);
        select.selectByIndex(5);

        WebElement gun= driver.findElement(By.xpath("//*[@title='Gün:']"));
        select=new Select(gun);
        select.selectByIndex(5);

        WebElement yil= driver.findElement(By.xpath("//*[@title='Yıl:']"));
        select=new Select(yil);
        select.selectByValue("2002");

        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();

        driver.switchTo().window(fakemailhan);
     //  WebElement mail= driver.findElement(By.xpath("(//tr[@data-href='2'])[1]"));
      WebElement mail= driver.findElement(By.xpath("(//tr[@data-href='2'])[1]/td[2]"));

       System.out.println(mail.getText());

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(mail));
        mail.click();
        driver.switchTo().frame(1);

      WebElement onaykodu=driver.findElement(By.xpath("" +
              "//*[@id=\"email_content\"]/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]"));
        wait.until(ExpectedConditions.visibilityOf(onaykodu));

        System.out.println(onaykodu);

        String onaykodu1=onaykodu.getText();
        System.out.println(onaykodu1);

        driver.switchTo().defaultContent();

        driver.switchTo().window(instagramhan);
        //onay kodu box
       WebElement onaykodubox=driver.findElement(By.xpath("//*[@name='email_confirmation_code']"));
       onaykodubox.sendKeys(onaykodu1);

       WebElement buyutec= driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(buyutec));
        buyutec.click();

        WebElement aramakutsu=driver.findElement(By.xpath("//*[@aria-label='Ara']"));
        wait.until(ExpectedConditions.visibilityOf(aramakutsu));
       aramakutsu.click();

       WebElement arama=driver.findElement(By.xpath("input[@type='text']"));
       arama.sendKeys("alas.yusuf47",Keys.ENTER);
       driver.findElement(By.xpath("//*[@id=\"mount_0_0_0I\"]/div/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/a[1]/div[1]/div/div/div[2]/div/div")).click();

waitofseconds(20);



    }


}