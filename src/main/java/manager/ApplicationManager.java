package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.EventListener;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {
//    WebDriver wd;
    HelperUser user;
    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;

    public HelperUser getUser() {
        return user;
    }

    public void setUser(HelperUser user) {
        this.user = user;
    }

    public void init(){
//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("All tests starts in Chrome browser");
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        user = new HelperUser(wd);
        contact = new HelperContact(wd);
        wd.register(new MyListener());
    }

    public HelperContact contact() {
        return contact;
    }

    public void setContact(HelperContact contact) {
        this.contact = contact;
    }

    public void stop(){
        wd.quit();
    }
}
