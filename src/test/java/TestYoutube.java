import org.junit.Test;

public class TestYoutube extends TestBase {

    @Test
    public void shouldSearchForPythonVideo(){
        youtubeMainPage.skipLoginToYoutube();
        youtubeMainPage.acceptCoogies();
        youtubeMainPage.searchForText("Python");
        youtubeResultsPage.clickOnFirstVideo();
        youtubeVideoPage.clickSkipButton();
        youtubeVideoPage.setProgressBarToMiddle();
        youtubeVideoPage.clickOnPlayPauseButton(); // first to pause
        youtubeVideoPage.clickOnPlayPauseButton();
        youtubeVideoPage.clickOnMuteButton();
        youtubeVideoPage.saveVideoDataToFile("videofile");
        youtubeVideoPage.goToNextVido();
        youtubeVideoPage.clickOnPlayPauseButton();
    }

}
