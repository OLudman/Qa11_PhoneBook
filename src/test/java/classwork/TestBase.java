package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass // BeforeSuite - before all classes
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void type(By locator, String text){
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass // AfterSuite
    public void tearDown(){
        wd.quit();
    }
}
