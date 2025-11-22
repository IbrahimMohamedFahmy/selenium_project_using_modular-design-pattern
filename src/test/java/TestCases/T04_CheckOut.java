package TestCases;

import SetUp.SuperClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class T04_CheckOut extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1, dataProvider = "TestData")
    public void UserAddProductAndCheckOutItFlowSuccessfully(HashMap<String, String> input)
    {
        // Step 1: Get the Current URL
        String HomeURL = driver.getCurrentUrl();

        // Step 2: verify That the Current URL and the HomeUrl are Match
        soft.assertEquals(HomeURL, input.get("HomeUrl"));

        // Step 3: Open Sign In Page
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        // Step 4: Get The Text Of The SignIn Form
        String SignUpText =driver.findElement(By.cssSelector("div[class='login-form'] h2")).getText();

        // Step 5: Check The SignUp Text
        soft.assertEquals(SignUpText, "Login to your account");

        // Step 6: Get The Email Text Filed and Type a Valid Email
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(input.get("ValidEmail"));

        // Step 7: Get the Password Text Filed and Type a Valid Password
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(input.get("Password"));

        // Step 8: Get Sign In Button and Click on it
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        // Step 9: Get the Target Element
        WebElement productCard = driver.findElement(By.xpath("//p[text()='Blue Top']/ancestor::div[@class='productinfo text-center']"));

        // Step 10: Scroll to Get The Element
        SuperClass.Scroll(productCard);

        // Step 12: click Add to Cart from same card
        productCard.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]")).click();

        // Step 13: Get Successful Message of add product
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Your product has been added to cart.']")));
        String SM = popup.getText();

        // Step 14: Check The Message
        soft.assertEquals(SM, "Your product has been added to cart.");

        // Step 15:Close popup
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();

        // Step 16: go to cart page
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        // Step 17: Get Current Url
        String CartURL = driver.getCurrentUrl();

        // Step 18: Check Actual and Expected URLs
        soft.assertEquals(CartURL, input.get("CartUrl"));

        // Step 19: Go to The CheckOut Page
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Step 20: Get Current Url
        String checkOutURL = driver.getCurrentUrl();

        // Step 21: Verify the Expected and Current URLs
        soft.assertEquals(checkOutURL, input.get("CheckOutPage"));

        // step 22: Scroll Down To Get Order Info
        SuperClass.Scroll(driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']")));

        // Step 23: Get Product Price
        String priceText = driver.findElement(By.cssSelector("td[class='cart_price'] p")).getText();
        double price = Double.parseDouble(priceText.replace("Rs.", "").trim());

        // Step 24: Get Product Quantity
        String quantityText = driver.findElement(By.cssSelector(".cart_quantity button")).getText();
        int quantity = Integer.parseInt(quantityText.trim());

        // Step 25: Get The Total Expected Price
        double TotalProductPrice1 = price * quantity;

        // Step 26: Get The Total Price Element
        String actualTotalText = driver.findElement(By.cssSelector(".cart_total_price")).getText();
        double actualTotal = Double.parseDouble(actualTotalText.replace("Rs.", "").trim());

        // Step 27: Check expectedTotalPrice eq actualTotal
        soft.assertEquals(TotalProductPrice1, actualTotal);

        // Step 23: Get Product Price for product-2
        String priceText2 = driver.findElement(By.cssSelector("#product-2 .cart_price p")).getText();
        double price2 = Double.parseDouble(priceText2.replace("Rs.", "").trim());

        // Step 24: Get Product Quantity
        String quantityText2 = driver.findElement(By.cssSelector("#product-2 .cart_quantity button")).getText();
        int quantity2 = Integer.parseInt(quantityText2.trim());

        // Step 25: Get The Total Expected Price
        double TotalProductPrice2 = price2 * quantity2;

        // Step 26: Get The Total Price Element
        String actualTotalText2 = driver.findElement(By.cssSelector("#product-2 .cart_total_price")).getText();
        double actualTotal2 = Double.parseDouble(actualTotalText2.replace("Rs.", "").trim());

        // Step 27: Check expectedTotalPrice eq actualTotal
        soft.assertEquals(TotalProductPrice2, actualTotal2);

        String actualCartTotalText = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[3]")).getText();
        double actualCartTotal = Double.parseDouble(actualCartTotalText.replace("Rs.", "").trim());

        // Step 28: Check The Price OF all Products On the Checkout Page
        soft.assertEquals(TotalProductPrice1+TotalProductPrice2, actualCartTotal);

        // Step 29: Call `assertAll()` to check all assertions
        soft.assertAll();
    };

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2, dataProvider = "TestData")
    public void UserPassCheckOutItFlowSuccessfully(HashMap<String, String> input)
    {
        // Step 1: Get the Current URL
        String HomeURL = driver.getCurrentUrl();

        // Step 2: verify That the Current URL and the HomeUrl are Match
        soft.assertEquals(HomeURL, input.get("HomeUrl"));

        // Step 3: Open Sign In Page
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        // Step 4: Get The Text Of The SignIn Form
        String SignUpText =driver.findElement(By.cssSelector("div[class='login-form'] h2")).getText();

        // Step 5: Check The SignUp Text
        soft.assertEquals(SignUpText, "Login to your account");

        // Step 6: Get The Email Text Filed and Type a Valid Email
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(input.get("ValidEmail"));

        // Step 7: Get the Password Text Filed and Type a Valid Password
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(input.get("Password"));

        // Step 8: Get Sign In Button and Click on it
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        // Step 9: go to cart page
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        // Step 10: Get Current Url
        String CartURL = driver.getCurrentUrl();

        // Step 11: Check Actual and Expected URLs
        soft.assertEquals(CartURL, input.get("CartUrl"));

        // Step 12: Go to The CheckOut Page
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();

        // Step 13: Get Current Url
        String checkOutURL = driver.getCurrentUrl();

        // Step 14: Verify the Expected and Current URLs
        soft.assertEquals(checkOutURL, input.get("CheckOutPage"));

        // step 15: Scroll Down To Get Order Info
        SuperClass.Scroll(driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']")));

        // Step 16: Get Product Price
        String priceText = driver.findElement(By.cssSelector("td[class='cart_price'] p")).getText();
        double price = Double.parseDouble(priceText.replace("Rs.", "").trim());

        // Step 17: Get Product Quantity
        String quantityText = driver.findElement(By.cssSelector(".cart_quantity button")).getText();
        int quantity = Integer.parseInt(quantityText.trim());

        // Step 18: Get The Total Expected Price
        double TotalProductPrice1 = price * quantity;

        // Step 19: Get The Total Price Element
        String actualTotalText = driver.findElement(By.cssSelector(".cart_total_price")).getText();
        double actualTotal = Double.parseDouble(actualTotalText.replace("Rs.", "").trim());

        // Step 20: Check expectedTotalPrice eq actualTotal
        soft.assertEquals(TotalProductPrice1, actualTotal);

        // Step 21: Get Product Price for product-2
        String priceText2 = driver.findElement(By.cssSelector("#product-2 .cart_price p")).getText();
        double price2 = Double.parseDouble(priceText2.replace("Rs.", "").trim());

        // Step 22: Get Product Quantity
        String quantityText2 = driver.findElement(By.cssSelector("#product-2 .cart_quantity button")).getText();
        int quantity2 = Integer.parseInt(quantityText2.trim());

        // Step 23: Get The Total Expected Price
        double TotalProductPrice2 = price2 * quantity2;

        // Step 24: Get The Total Price Element
        String actualTotalText2 = driver.findElement(By.cssSelector("#product-2 .cart_total_price")).getText();
        double actualTotal2 = Double.parseDouble(actualTotalText2.replace("Rs.", "").trim());

        // Step 25: Check expectedTotalPrice eq actualTotal
        soft.assertEquals(TotalProductPrice2, actualTotal2);

        String actualCartTotalText = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[3]")).getText();
        double actualCartTotal = Double.parseDouble(actualCartTotalText.replace("Rs.", "").trim());

        // Step 26: Check The Price OF all Products On the Checkout Page
        soft.assertEquals(TotalProductPrice1+TotalProductPrice2, actualCartTotal);

        // Step 27: Call `assertAll()` to check all assertions
        soft.assertAll();
    };


    @DataProvider
    public Object[][] TestData() throws IOException
    {
        String jsonFile = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//main//resources//TestData.json"), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> DataList = objectMapper.readValue(jsonFile, new TypeReference<List<HashMap<String, String>>>() {});

        Object[][] Data = new Object[DataList.size()][1];
        for(int i = 0 ; i < DataList.size() ; i++)
        {
            Data[i][0] = DataList.get(i);
        }
        return Data;

    }
}
