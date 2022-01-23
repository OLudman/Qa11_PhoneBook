import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HmwIlCarroLogin {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void LoginPositiveTest(){
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='Log in']")); // css div.header a:last-child
        loginBtn.click();
        WebElement emailInput = wd.findElement(By.xpath("//input[@id='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("olgaludman@gmail.com");
        WebElement passInput = wd.findElement(By.xpath("//input[@id='password']"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Ol4ik1Ya");
//        wd.findElement(By.cssSelector("button[type='submit']")).click();
        wd.findElement(By.xpath("//form//button[1]")).click();
        wd.findElement(By.xpath("//button[text()='Ok']")).click();
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
