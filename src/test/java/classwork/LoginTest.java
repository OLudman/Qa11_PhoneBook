package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void LoginPositiveTest(){
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("noa@gmail.com");
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Nnoa12345$");
        wd.findElement(By.xpath("//button[1]")).click();
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size()>0);
    }

    @Test
    public void loginTest2(){
        String email = "noa@gmail.com";
        String password = "Nnoa12345$";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

}
