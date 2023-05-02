package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void userGoToLoginPage(){
        login.loginLink().click();
    }
    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl =" https://demo.nopcommerce.com/";
        String actualUrl = Hooks.driver.getCurrentUrl();
        softAssert.assertTrue(expectedUrl.equals(actualUrl));
        softAssert.assertTrue(login.myAccount().isDisplayed());
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert softAssert = new SoftAssert();
        String expectedMessage = "Login was unsuccessful.";
        String actualMessage = login.messageError().getText();
        softAssert.assertTrue(expectedMessage.contains(actualMessage));
        String expectedColor = "#e4434b";
        String actualColor = login.messageError().getCssValue("color");
        String actualColorHex = Color.fromString(actualColor).asHex();
        softAssert.assertTrue(expectedColor.equals(actualColorHex));

    }

    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }
}
