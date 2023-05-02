package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_Register register= new P01_Register();

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        register.registerLink().click();
    }
    @When("user select gender type")
    public void userSelectGenderType(){
        register.genderMale().click();
    }

    @And("user enter {string} & {string}")
    public void userEnter(String fristname , String lastename) {
        register.firstName().sendKeys(fristname);
        register.lastName().sendKeys(lastename);

    }



    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay = new Select(register.dateOfBirthDay());
        selectDay.selectByIndex(16);
        Select selectMonth = new Select(register.dateOfBirthMonth());
        selectMonth.selectByVisibleText("September");
        Select selectYear = new Select(register.dateOfBirthYear());
        selectYear.selectByValue("1916");

    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        register.email().sendKeys(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmPassword) {
        register.password().sendKeys(password);
        register.confirmPassword().sendKeys(confirmPassword);

    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerClick().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        String expectedMessage = "Your registration completed";
        String actualMessage = register.successMessage().getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage,expectedMessage);
        softAssert.assertTrue(expectedMessage.equals(actualMessage));

//        String expectedColor = "#4cb17c";
//        String actualColor = register.successMessage().getCssValue("color");
//        String actualColorHex = Color.fromString(actualColor).asHex();
//        softAssert.assertTrue(expectedColor.equals(actualColorHex));
        String expectedColor ="#4cb17c";
        String actualColor = register.successMessage().getCssValue("color");
        String actualColorHex = Color.fromString(actualColor).asHex();
        softAssert.assertEquals(actualColorHex,expectedColor);
    }

}
