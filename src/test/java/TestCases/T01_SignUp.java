package TestCases;

import SetUp.SuperClass;
import org.testng.annotations.Test;

public class T01_SignUp extends SuperClass
{
    @Test(groups = {"Happy Scenarios", "All Scenarios"}, priority = 1)
    public void SignUpWithValidData()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 2)
    public void SignUpWithInvalidEmail()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 3)
    public void SignUpWithEmptyFields()
    {
    };

    @Test(groups = {"Sad Scenarios", "All Scenarios"}, priority = 1)
    public void SignUpWithExistingEmail()
    {
    };




}
