package TestCases;

import SetUp.SuperClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class T03_Cart extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1, dataProvider = "TestData")
    public void AddAProductToCartSuccessfully(HashMap<String, String> input)
    {
    };

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2, dataProvider = "TestData")
    public void AddMoreThanProductToCartSuccessfully(HashMap<String, String> input)
    {
    };

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 3, dataProvider = "TestData")
    public void AddAProductToCartFromHisPageSuccessfully(HashMap<String, String> input)
    {
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

    /*
    context("Sad Scenarios", function()
    {
        it("should redirect unauthenticated user to login page", function()
            {
                // step 1: user try to access products page during the url
                cy.visit("https://www.saucedemo.com/inventory.html", { failOnStatusCode: false });

                // step 2: check the user will redirect to sign in page
                cy.checkUrl(userData.SignInPage);
            });

            it("should not allow adding product without login", function()
            {
                // step 1: user try to access product page during the url
                cy.visit("https://www.saucedemo.com/inventory-item.html?id=4", { failOnStatusCode: false });

                // step 2: verify that the add to cart button not exists
                P02_AddToCart.AddProductToCart().should("not.exist")

                // step 3: check the user will redirect to sign in page
                 cy.checkUrl(userData.SignInPage);
            });
     */
}
