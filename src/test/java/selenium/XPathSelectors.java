package selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSelectors {

    public class CssSelectors {
        private WebDriver driver;

        @BeforeEach
        void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        void shouldFindXPathLocators() {

            //Login page:
            //“Username/ID” input
            driver.findElement(By.xpath("//*[@id='passp-field-login']"));

            //“I forgot” link
            driver.findElement(By.xpath("//*[contains(text(), 'forgot')]"));

            //“Log in” button
            driver.findElement(By.xpath("//*[@id='passp:sign-in']"));

            //“Password” input
            driver.findElement(By.xpath("//*[@id='passp-field-passwd']"));

            //“Show password” button (eye)
            driver.findElement(By.xpath("//*[@id='password-toggle']"));

            //“Log in with QR-code" button
            driver.findElement(By.xpath("//*[@class='AuthPasswordForm-qr-button']/button"));

            //“Forgot your password?” link
            driver.findElement(By.xpath("//*[text()='Forgot your password?']"));






            //Email page:
            //“Write email” button
            driver.findElement(By.xpath("//*[text()='Compose']"));

            //“Logout” link
            driver.findElement(By.xpath("//*[text()='Log out']"));

            //“Settings” link
            driver.findElement(By.xpath("//*[text()='Settings']"));

            //1 locator for all 5 elements: Inbox, Sent, Deleted, Spam and Draft links
            driver.findElement(By.xpath("//*[@aria-label='Папки']"));

            //1 locator for all 4 elements: Inbox, Deleted, Spam and Draft links
            driver.findElement(By.xpath("//*[@aria-label='Папки']//*[text()='Inbox' or text()='Trash' or text()='Spam']"));







            //New email page:
            //“To” input
            driver.findElement(By.xpath("//*[@id='id1167432530228']"));

            //“Topic” input
            driver.findElement(By.xpath("//*[@id='id1167432530213']"));

            //“Find” button
            driver.findElement(By.xpath("//*[@value = 'Search']"));

            //“Add multiple attachments” button
            driver.findElement(By.xpath("//*[text()='Add multiple attachments']"));

            //1 locator for all 3 elements: Send, Save and Cancel inputs
            driver.findElement(By.xpath("//*[@class='b-buttons']/input[@type='submit']"));

            //Update locator for all 3 elements: Send, Save and Cancel inputs
            driver.findElement(By.xpath("//input[@name='doit' or @name='nosend' or @name='cancel']"));

            //Update locator for all 3 elements: Send, Save and Cancel inputs
            driver.findElement(By.xpath("//input[contains(@class, 'b-form-button')]"));

            //Update locator for all 3 elements: Send, Save and Cancel inputs
            driver.findElement(By.xpath("//input[@name='doit' or @name='nosend']"));






            //Sent page:
            //Xpath only. Locator to get all links to topics starting from 2nd email
            driver.findElement(By.xpath("//*[@class='b-messages']//div[position()>1]//*[@class='b-messages__subject']"));
        }
    }
}
