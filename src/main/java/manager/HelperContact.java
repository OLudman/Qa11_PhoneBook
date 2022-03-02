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
        click(By.xpath("//b"));
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".count-item_card_2SOIM")).size();
    }

    public boolean isContactCreatedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list){
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactCreatedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list){
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void removeOneContact(){
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card_2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public void removeOneContactCount(){
        int countBefore = countOfContacts();
        logger.info("Before remove 'One contact tests' contact was ---- > " + countBefore);

        if(!isContactListEmpty()){
            String phone = wd.findElement(By.cssSelector(".contact-item_card_2SOIM h3")).getText();
            logger.info("The removed number was---->" + phone);
            wd.findElement(By.cssSelector(".contact-item_card_2SOIM")).click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(500);
        }
    }

}
