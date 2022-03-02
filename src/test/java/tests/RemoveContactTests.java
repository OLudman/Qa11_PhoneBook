package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(!app.getUser().isLogged()){
            app.getUser().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345"));
        }
    }

    @Test
    public void removeOneContact(){
        //countStart
        app.contact().removeOneContact();
        //countEnd
        //assert countStart- countEnd =1
    }

    @Test
    public void removeOneContactCount(){
//        int count = app.contact().removeOneContact();
//        assert countStart- countEnd =1
    }
}
