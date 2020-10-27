import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class YoutubeMainPage {

    WebDriver driver;

    @FindBy(xpath="//input[@id='search']")
    WebElement searchInput;

    @FindBy(id = "dismiss-button")
    WebElement skipButton;

    @FindBy(id = "introAgreeButton")
    WebElement cookiesAgreeButton;


    public YoutubeMainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void skipLoginToYoutube(
    ){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        skipButton.click();
    }

    public void acceptCoogies() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", cookiesAgreeButton);
    }

    public void searchForText(String text){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        searchInput.sendKeys(text);
        searchInput.submit();
    }
}
