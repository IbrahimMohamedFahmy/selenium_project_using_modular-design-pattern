package TestCases;

import SetUp.SuperClass;
import org.testng.annotations.Test;

public class T02_SignIn extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1)
    public void SignInWithValidData()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 2)
    public void SignInWithInValidEmail()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 3)
    public void SignInWithInValidPassword()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 4)
    public void SignInWithNotExistingEmail()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 5)
    public void SignInWithEmptyFields()
    {
    };
}
