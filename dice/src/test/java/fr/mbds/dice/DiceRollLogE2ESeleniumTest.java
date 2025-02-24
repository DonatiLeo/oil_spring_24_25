package fr.mbds.dice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.AdditionalMatchers.and;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiceRollLogE2ESeleniumTest {
    private WebDriver driver;

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void setUpClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() throws Exception {
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void helloPageHasTextHelloWorld() {
        driver.navigate().to(String.format("http://localhost:%s/rollDice", port));

        var body = driver.findElement(By.tagName("body"));

        assertThat(body.getText(), containsString("results"));
    }
}
