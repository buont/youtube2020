import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
    WebDriver driver;
    Actions action;
    YoutubeVideoPage youtubeVideoPage;
    YoutubeMainPage youtubeMainPage;
    YoutubeResultsPage youtubeResultsPage;
@Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        action = new Actions(driver);
        youtubeMainPage = new YoutubeMainPage(driver);
        youtubeResultsPage = new YoutubeResultsPage(driver);
        youtubeVideoPage = new YoutubeVideoPage(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
