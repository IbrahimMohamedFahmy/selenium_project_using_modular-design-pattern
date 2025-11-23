🧪 Selenium Project Using Modular Design Pattern
Overview

📌 This project is a Selenium automation framework implemented using the Modular Design Pattern.
It contains both Happy Scenarios and Sad Scenarios for testing different flows in the application, including Sign Up, Sign In, Cart operations, Checkout, and Sign Out flows.

```
selenium_project_using_modular-design-pattern/
│
├─ .idea/
├─ src/
│  ├─ main/
│  │  └─ resources/
│  │     └─ TestData.json           # Test data for Happy and Sad scenarios
│  └─ test/
│     └─ java/
│        ├─ SetUp/
│        │   ├─ SuperClass.java     # Base class for all tests
│        │   └─ Listeners.java      # TestNG listener for logging and reports
│        └─ TestCases/
│            ├─ T01_SignUp.java
│            ├─ T02_SignIn.java
│            ├─ T03_Cart.java
│            ├─ T04_CheckOut.java
│            └─ T05_SignOut.java
│
├─ .gitignore
├─ pom.xml
├─ README.md
├─ TestNGAllScenarios.xml
├─ TestNGSadScenarios.xml
└─ TestNG_HappyScenarios.xml
```
```
Test Scenarios:
Happy Scenarios:

Successful Sign Up

Successful Sign In

Adding Products to Cart

Checkout flow

Sign Out flow

Sad Scenarios:

Sign Up with invalid data

Sign In with invalid credentials

Checkout with empty cart

Sign Out flow errors

Test Data:

All test data is stored in src/main/resources/TestData.json.
Both Happy and Sad scenarios read input from this JSON file.

How to Run Tests?
Prerequisites

Java JDK 11+

Maven 3+

Browser drivers (ChromeDriver)

TestNG plugin installed

Run Using Maven
mvn clean test

Run Specific TestNG XML:
mvn test -DsuiteXmlFile=TestNG_HappyScenarios.xml
mvn test -DsuiteXmlFile=TestNGSadScenarios.xml
mvn test -DsuiteXmlFile=TestNGAllScenarios.xml

Listeners & Reporting

Listeners.java integrates with Extent Reports for better test logging and reporting.

Screenshots are captured on test failures.

Notes

Framework follows Modular Design Pattern, making it easy to add new test cases or flows.

Test classes are independent and reusable.

All locators and test data are externalized for better maintainability.

How to Clone the Project

1️⃣ Copy the GitHub Repository Link
Go to the project on GitHub:
https://github.com/IbrahimMohamedFahmy/selenium_project_using_modular-design-pattern

Click the Code button and copy the HTTPS link:

https://github.com/IbrahimMohamedFahmy/selenium_project_using_modular-design-pattern.git

2️⃣ Open Terminal or Command Prompt
Windows: Use Git Bash or Command Prompt

Mac/Linux: Use Terminal

3️⃣ Run the Git Clone Command
git clone https://github.com/IbrahimMohamedFahmy/selenium_project_using_modular-design-pattern.git

This will create a local copy of the project in a folder with the same name.

4️⃣ Navigate to the Project Folder
cd selenium_project_using_modular-design-pattern

5️⃣ Run the Project

Since this is a Maven project, you can run all tests using:

mvn clean test


To run a specific TestNG XML suite:

mvn test -DsuiteXmlFile=TestNG_HappyScenarios.xml
mvn test -DsuiteXmlFile=TestNGSadScenarios.xml
mvn test -DsuiteXmlFile=TestNGAllScenarios.xml

🔹 Notes

Make sure Java JDK and Maven are installed on your machine.

You can also open the project in IntelliJ IDEA as a Maven project for easier management.

🧑‍💻 Author

Engineer Ibrahim Omran – QA Automation Engineer
Passionate about software quality, test automation, and continuous improvement.

📅 Last Updated

November 2025
```
