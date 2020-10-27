import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    YoutubeVideoPage youtubeVideoPage;
    YoutubeMainPage youtubeMainPage;
    YoutubeResultsPage youtubeResultsPage;
@Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        youtubeMainPage = new YoutubeMainPage(driver);
        youtubeResultsPage = new YoutubeResultsPage(driver);
        youtubeVideoPage = new YoutubeVideoPage(driver);
    }

    @After
    public void teardown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

}
