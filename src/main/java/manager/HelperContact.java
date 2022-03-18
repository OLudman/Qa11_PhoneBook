package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelperContact extends HelperBase{
    org.slf4j.Logger logger = LoggerFactory.getLogger(MyListener.class);

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getEmail());
        type(By.cssSelector("[placeholder='email']"), contact.getPhone());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveContactForm() {
        click(By.cssSelector(".add_form__2rsm2 button"));
//       click(By.xpath("//b"));
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public boolean isContactCreatedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list){
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactCreatedByEmail(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list){
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void removeOneContact(){
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public int removeOneContactCount(){
        int countBefore = countOfContacts();
        logger.info("Before remove 'One contact tests' contact was ---- > " + countBefore);

        if(!isContactListEmpty()){
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The removed number was---->" + phone);
            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(500);
        }

        int countAfter = countOfContacts();
        logger.info("After remove 'One contact tests' count is ---- > " + countAfter);

        return countAfter - countBefore;

    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM h3")).isEmpty();
    }

    public void providerOfContacts() {
        if(countOfContacts()<3){
            int index = (int)(System.currentTimeMillis()/1000)%3600;
            for (int i=0; i<3; i++){
                Contact contact = Contact.builder()
                        .name("Zoa")
                        .lastName("Snow")
                        .phone("1212"+i+index)
                        .email("zoa"+i+index+"@gmail.com")
                        .address("Haifa")
                        .description("Friend")
                        .build();
                openContactForm();
                fillContactForm(contact);
                saveContactForm();
                pause(1000);
            }
        }
    }

    public void removeAllContactsNotWork() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        for (WebElement el: list){
            el.click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(500);
        }
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0)
        {
            removeOneContactCount();
        }

    }
}
