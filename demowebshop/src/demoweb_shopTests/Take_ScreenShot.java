package demoweb_shopTests;
import java.io.File;
import demoweb_shop.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Take_ScreenShot extends BasePage {
    @Test

    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);
            //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(fileWithPath);
            FileUtils.copyFile(SrcFile, DestFile);
        }
    }

