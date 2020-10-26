import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeMainPage {

    WebDriver driver;

    @FindBy(xpath="//input[@id='search']")
    WebElement searchInput;

    public YoutubeMainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void searchForText(String text){
        searchInput.sendKeys(text);
        searchInput.submit();
    }
}
