package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text){
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void takeScreenshot(String link){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenShot = new File(link);

        try {
            Files.copy(tmp,screenShot);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
