package demoweb_shop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddToCartPage extends BasePage{

    // list of products
    int total = 0;
    @FindBy(how = How.XPATH, using = "//div[@class='item-box']//div[@class='product-item']")
    static List<WebElement> List_of_elements;

    // select amount
    @FindBy(how = How.XPATH, using = "//div[@class='prices']//span[@class='price actual-price']")
    static WebElement selectAmount;

    @Test
    public void select_product() throws IOException {
        AddToCartPage addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);

        List<String> AllElement = new ArrayList<>();
        for (int i = 0; i < List_of_elements.size(); i++)
            AllElement.add(List_of_elements.get(i).getText());

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File("D://automation//save screen shot.png"));
    }
}
