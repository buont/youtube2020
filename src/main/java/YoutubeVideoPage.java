import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class YoutubeVideoPage {
    WebDriver driver;
    Actions action;
    @FindBy(xpath="//*[@class='ytp-bound-time-right']")
    WebElement videoDuration;

    @FindBy(className="ytp-progress-bar")
    WebElement progressBar;

    @FindBy(xpath="//*[@class='ytp-play-button ytp-button']")
    WebElement playButton;

    @FindBy(xpath="//*[@class='ytp-mute-button ytp-button']")
    WebElement muteButton;

    @FindBy(xpath="//h1[1]")
    WebElement titleOfVideo;

    @FindBy(xpath="//*[@class='style-scope ytd-channel-name']")
    WebElement channelName;

    public YoutubeVideoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void setProgressBarToMiddle(){
        int widthOfProgressBar = progressBar.getSize().getWidth();
        action.moveToElement(progressBar).moveByOffset(widthOfProgressBar/2,0).click().perform();
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
            fw.write(titleOfVideo.getText() +";" + channelName.getText()+";"+ videoDuration.getText());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
