package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    @Test
//    public void LoginPositiveTest(){
//        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
//        loginBtn.click();
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("noa@gmail.com");
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Nnoa12345$");
//        wd.findElement(By.xpath("//button[1]")).click();
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size()>0);
//    }

    @Test
    public void loginTest2Positive(){
        User user = new User().withPassword("Nnoa12345$").withEmail("noa@gmail.com");

        app.getUser(). openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginTestNegativeWrongPassword(){
        User user = new User().withPassword("Nnoa12345").withEmail("noa@gmail.com");

        app.getUser(). openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isAllertPresent());
    }

}
