package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();  // se tup the Chrome browser driver

        driver.get(baseUrl); // load the url

        driver.manage().window().maximize(); // maximise the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();  // quit the browser
    }

}
