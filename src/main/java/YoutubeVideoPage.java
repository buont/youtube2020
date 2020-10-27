import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class YoutubeVideoPage {
    WebDriver driver;
    Actions action;
    @FindBy(className="ytp-bound-time-right")
    WebElement videoDuration;

    @FindBy(className="ytp-ad-skip-button-container")
    WebElement skipButton;

    @FindBy(className="ytp-progress-bar")
    WebElement progressBar;

    @FindBy(xpath="//*[@class='ytp-play-button ytp-button']")
    WebElement playButton;

    @FindBy(xpath="//*[@class='ytp-mute-button ytp-button']")
    WebElement muteButton;

    @FindBy(xpath="//h1[1]")
    WebElement titleOfVideo;

    @FindBy(xpath="//ytd-video-owner-renderer[1]/div[1]/ytd-channel-name[1]/div[1]/div[1]/yt-formatted-string[1]/a[1]")
    WebElement channelName;

    @FindBy(css = "#count > yt-view-count-renderer")
    WebElement viewsCounter;

    @FindBy(xpath = "//ytd-toggle-button-renderer[2]/a[1]/yt-formatted-string[1]")
    WebElement dislikeCounter;

    @FindBy(xpath = "//ytd-toggle-button-renderer[1]/a[1]/yt-formatted-string[1]")
    WebElement likeCounter;


    @FindBy(xpath = "//ytd-video-primary-info-renderer[1]/div[1]/div[1]/div[1]/div[2]/yt-formatted-string[1]")
    WebElement uploadDate;

    @FindBy(tagName = "ytd-compact-autoplay-renderer")
    WebElement nextVideo;


    public YoutubeVideoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickSkipButton(){
        if (skipButton.isDisplayed()){
            skipButton.click();
        }else {

        }
    }
    public void setProgressBarToMiddle(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        action = new Actions(driver);
        int widthOfProgressBar = progressBar.getSize().getWidth();
        action.moveToElement(progressBar).moveByOffset((widthOfProgressBar/2)-2,0).click().perform();
    }
    public void clickOnPlayButton(){
        playButton.click();
    }

    public void clickOnMuteButton(){
        muteButton.click();
    }

    public  void  saveVideoDataToFile(String filename)
    {
        try {
            File newTextFile = new File(filename+".csv");
            newTextFile.createNewFile();
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(uploadDate.getText() +";" +viewsCounter.getText() +";" +dislikeCounter.getText() +";" + likeCounter.getText() +";" + titleOfVideo.getText() +";" + channelName.getText()+";"+ videoDuration.getText());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void  goToNextVido(){
        nextVideo.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    }

}
