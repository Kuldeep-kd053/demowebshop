package demoweb_shop;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import demoweb_shopTests.Take_ScreenShot;
import java.util.*;

import static demoweb_shop.Login_SignUpPage.login;

public class Mapping_product extends BasePage{


    @FindBy(how = How.XPATH,using = "//div[@class='product-grid home-page-product-grid']//following::h2[@class='product-title']")
    static List<WebElement> Product_list;

    @FindBy(how = How.XPATH,using = "//div[@class='product-grid home-page-product-grid']//following::span[@class='price actual-price']")
    List<WebElement> Price_list;
    static Take_ScreenShot take_screenShot= new Take_ScreenShot();
    @Test
    public static void mapping_product() throws InterruptedException{
        Mapping_product mapping_product = PageFactory.initElements(driver, Mapping_product.class);
        login("Vikash1@Kumar.com","Vikash@kumar");
        String product_name = "";
        String product_price;
        int int_product_price = 0;
        HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        for(int i=0;i<Product_list.size();i++) {
            product_name = Product_list.get(i).getText();//Iterate and fetch product name
            product_price = Product_list.get(i).getText();//Iterate and fetch product price
            product_price = product_price.replaceAll("[^0-9]", "");
            //Replace anything wil space other than numbers
            int_product_price = Integer.parseInt(product_price);//Convert to Integer

            System.out.println("Continuing execution...");
        }
            map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
            Reporter.log("Product Name and price fetched from UI and saved in HashMap as:" +
                    map_final_products.toString() + "<br>",true);
            System.out.println(map_final_products);

            //Get all the keys from Hash Map
            Set<Integer> allkeys = map_final_products.keySet();
            ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

            //Sort the Prices in Array List using Collections class
            //this will sort in ascending order lowest at the top and highest at the bottom
            Collections.sort(array_list_values_product_prices);

            //Highest Product is
            int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);

            //Low price is
            int low_price = array_list_values_product_prices.get(0);


    }
}

