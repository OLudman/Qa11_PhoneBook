package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getUser().isLogged()){
            app.getUser().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
    }

    @Test (dataProvider =  "ContactValidData", dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessNew(Contact contact){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' starts with count of contacts --->"+countStart);
        logger.info("The test 'Add new contact' starts with data ---->" +contact.toString());

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContactForm();

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end ---->"+ countEnd);

        app.contact().pause(2000);
        Assert.assertEquals(countEnd-countStart, 1);
        Assert.assertTrue(app.contact().isContactCreatedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreatedByPhone(contact.getPhone()));
    }

    @Test (invocationCount = 3) //how much contacts will be opened
    public void addNewContactPositive(){
//        if(count>5){
//            remove all_contacts();
//        }
        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' starts with count of contacts --->"+countStart);

        int index = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Vasya")
                .lastName("Vasiliev")
                .email("Vasyavasiliev" + index+ "@gmail.com")
                .phone("1234567"+index)
                .address("Haifa")
                .description("any description")
                .build();
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContactForm();
//        Assert.assertTrue(app.contact().isContactPageDisplayed());
//        if_countStart-countEnd = -1
//        if list contact with name +phone

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end ---->"+ countEnd);

        Assert.assertEquals(countEnd-countStart, 1);
        Assert.assertTrue(app.contact().isContactCreatedByName(contact.getName()));
//        Assert.assertTrue(app.contact().isContactCreatedByPhone(contact.getPhone()));
    }

    @Test (enabled = false) // (dataProvider =  "dt")
    public void addNewContactSuccess(){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' starts with count of contacts --->"+countStart);

        int index = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Vasya")
                .lastName("Vasiliev")
                .email("Vasyavasiliev" + index+ "@gmail.com")
                .phone("1234567"+index)
                .address("Haifa")
                .description("any description")
                .build();
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContactForm();
//        Assert.assertTrue(app.contact().isContactPageDisplayed());
//        if_countStart-countEnd = -1
//        if list contact with name +phone

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end ---->"+ countEnd);
        app.contact().pause(2000);

        Assert.assertEquals(countEnd-countStart, 1);
        Assert.assertTrue(app.contact().isContactCreatedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreatedByPhone(contact.getPhone()));
    }
}
