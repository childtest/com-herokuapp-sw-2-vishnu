package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://the-internet.herokuapp.com/login";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter the required details
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // click on Login button
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

        //verify the Secure Area text
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        //String actualText = driver.findElement(By.xpath("//div[@id= 'flash'][@class = 'flash success']")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Secure Area not displayed", expectedText, actualText);


        // click on Login-out button
        driver.findElement(By.xpath("//i[@class = 'icon-2x icon-signout']")).click();

        //verify the Secure Area text
        String expectedText1 = "You logged out of the secure area!";
        String actualText2 = driver.findElement(By.xpath("//div[@id= 'flash'][@class = 'flash success']")).getText().split("\n")[0];

        // Verify with Assert Junit test
        Assert.assertEquals("You not logged out of the secure area!", expectedText1, actualText2);

    }


    @Test
    public void verifyTheUsernameErrorMessage() {

        // Enter the required details
        driver.findElement(By.id("username")).sendKeys("tomsmith11");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // click on Login button
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

        //verify the Secure Area text
        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText().split("\n")[0];

        // Verify with Assert Junit test
        Assert.assertEquals("Your username is invalid! text is not match", expectedText, actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {

        // Enter the required details
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecret");

        // click on Login button
        driver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

        //verify the Secure Area text
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText().split("\n")[0];

        // Verify with Assert Junit test
        Assert.assertEquals(" Your password is invalid! text is not match", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
