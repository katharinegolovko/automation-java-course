package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ByLocators {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void locators() {
        driver.get("https://mail.yandex.com");

        //By CSS id:
        driver.findElement(By.id("mobile"));

        //By CSS class:
        driver.findElement(By.className("button2__text"));

        //By XPath:
        driver.findElement(By.xpath("//*[@class='Tile-Title' and contains(text(), 'Secure')]"));

        //By Link text:
        driver.findElement(By.linkText("Help and support"));

        //By Partial Link text:
        driver.findElement(By.partialLinkText("support"));

        //By tag:
        driver.findElement(By.tagName("div"));

        //By name:
        driver.findElement(By.name("google"));

        //By CSS selector:
        driver.findElement(By.cssSelector("#index-page-container .Header"));
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
