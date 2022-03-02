package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationTestPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistrationForm();

        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void registrationTestWrongEmail(){
        app.getUser().takeScreenshot("src/test/screenShots/rst.png");
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "noa"+ i+ "gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistrationForm();

        Assert.assertFalse(app.getUser().isLogged());
    }

}
