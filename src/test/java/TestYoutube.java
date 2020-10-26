import org.junit.Test;

public class TestYoutube extends TestBase {

    @Test
    public void shouldSearchForPythonVideo(){
        youtubeMainPage.searchForText("Python");
        youtubeResultsPage.clickOnFirstVideo();
        youtubeVideoPage.setProgressBarToMiddle();
        youtubeVideoPage.saveVideoDataToFile("video");
    }

}
