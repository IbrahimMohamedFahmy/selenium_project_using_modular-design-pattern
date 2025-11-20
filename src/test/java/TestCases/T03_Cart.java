package TestCases;

import SetUp.SuperClass;
import org.testng.annotations.Test;

public class T03_Cart extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1)
    public void AddAProductToCartSuccessfully()
    {
    };

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 2)
    public void AddMoreThanProductToCartSuccessfully()
    {
    };

    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 3)
    public void AddAProductToCartFromHisPageSuccessfully()
    {
    };

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
