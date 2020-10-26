import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeResultsPage {

        WebDriver driver;

        @FindBy(xpath="//a[@id='video-title'][1]")
        WebElement firstVideoTitle;
        public YoutubeResultsPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
        public void clickOnFirstVideo(){
            firstVideoTitle.click();
        }
    }

