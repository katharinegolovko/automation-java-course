package selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void shouldFindCSSLocators() {

        //Login page:
        //“Username/ID” input
        driver.findElement(By.cssSelector("#passp-field-login"));

        //“I forgot” link
        driver.findElement(By.cssSelector("#field:link-login a"));

        //“Log in” button
        driver.findElement(By.cssSelector("#passp:sign-in"));

        //“Password” input
        driver.findElement(By.cssSelector("#passp-field-passwd"));

        //“Show password” button (eye)
        driver.findElement(By.cssSelector("#password-toggle"));

        //“Log in with QR-code" button
        driver.findElement(By.cssSelector(".AuthPasswordForm-qr-button button"));

        //“Forgot your password?” link
        driver.findElement(By.cssSelector(".Field-link a"));






        //Email page:
        //“Write email” button
        driver.findElement(By.cssSelector(".b-toolbar__i [aria-label='Compose']"));

        //“Logout” link
        driver.findElement(By.cssSelector(".b-header__right .b-header__link_exit"));

        //“Settings” link
        driver.findElement(By.cssSelector(".b-header__right .b-header__link_setup"));

        //1 locator for all 5 elements: Inbox, Sent, Deleted, Spam and Draft links
        driver.findElement(By.cssSelector(".b-folders .b-folders__folder__name a"));

        //1 locator for all 4 elements: Inbox, Deleted, Spam and Draft links
        driver.findElement(By.cssSelector(".b-folders .b-folders__folder:not(:nth-child(2)) a"));







        //New email page:
        //“To” input
        driver.findElement(By.cssSelector("#id1169805404373"));

        //“Topic” input
        driver.findElement(By.cssSelector("#id1169805404357"));

        //“Find” button
        driver.findElement(By.cssSelector("[name ='search']"));

        //“Add multiple attachments” button
        driver.findElement(By.cssSelector(".b-compose__more-attach button"));

        //1 locator for all 3 elements: Send, Save and Cancel inputs
        driver.findElement(By.cssSelector(".b-buttons .b-form-button"));

        //Update locator for all 3 elements: Send, Save and Cancel inputs
        driver.findElement(By.cssSelector(".b-buttons [value='Send'],[value='Save'], [value='Cancel']"));

        //Update locator for all 3 elements: Send, Save and Cancel inputs
        driver.findElement(By.cssSelector(".b-buttons input:not(.b-compose__file)"));

        //Update locator for all 3 elements: Send, Save and Cancel inputs
        driver.findElement(By.cssSelector(".b-buttons>input:not(.b-compose__file)"));






        //Sent page:

        //Css only. Locator to get even links to topics starting from 4th email
        driver.findElement(By.cssSelector(".b-messages__message:nth-of-type(1n+4) .b-messages__subject"));

    }
}
