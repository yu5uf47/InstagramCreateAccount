package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
public void selectvisible(WebElement ddm, String option){
    Select select=new Select(ddm);
    select.selectByVisibleText(option);

}

public void selectIndex(WebElement ddm, int Index){
    Select select=new Select(ddm);
    select.selectByIndex(Index);

}

public void waitofseconds(int index)  {

    try {
        Thread.sleep(index*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}

//window Handles

    public void window(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //iframe index

    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }



public void screenShot(){

    String date= DateTimeFormatter.ofPattern("dd.MM.yy_HH:mm:ss").format(LocalDateTime.now());
    String dosyaYolu="src/test/java/screenShot/"+date+"screenShot.jpg";
    TakesScreenshot ts= (TakesScreenshot) driver;

    try {
        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public void screenShotOfWebElement(WebElement webElement,String str){

    String date= DateTimeFormatter.ofPattern("dd.MM.yy_HH:mm:ss").format(LocalDateTime.now());

    String dosyaYolu="src/test/java/screenShot/"+date+ str+".jpg";

    try {
        Files.write(Paths.get(dosyaYolu),webElement.getScreenshotAs(OutputType.BYTES));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}



}
