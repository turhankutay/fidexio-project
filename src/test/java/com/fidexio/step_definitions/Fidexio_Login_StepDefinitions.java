package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLoginPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Fidexio_Login_StepDefinitions {

    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }

    @When("User enters username {string}")
    public void userEntersUsername(String arg0) {

        fidexioLoginPage.usernameInput.sendKeys(arg0);
        
    }

    @And("User enters password {string}")
    public void userEntersPassword(String arg0) {

        fidexioLoginPage.passwordInput.sendKeys(arg0);

    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {

        fidexioLoginPage.loginButton.click();
        
    }

    @Then("The user should be logged in to the page and see the Odoo title")
    public void theUserShouldBeLoggedInToThePageAndSeeTheOdooTitle() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Odoo";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("The user should see the Wrong login password alert on the page")
    public void theUserShouldSeeTheWrongLoginPasswordAlertOnThePage() {

        Assert.assertTrue(fidexioLoginPage.wrongLoginPasswordAlert.isDisplayed());

    }

    @Then("User should see Please fill out this field. message on password input")
    public void userShouldSeeMessage() {

        String actualMessage2 = fidexioLoginPage.passwordInput.getAttribute("validationMessage");
        String expectedMessage2 = "Please fill in this field.";
        Assert.assertEquals(expectedMessage2, actualMessage2);

    }

    @Then("User should see Please fill out this field. message on username input")
    public void userShouldSeePleaseFillOutThisFieldMessageOnUsernameInput() {

        String actualMessage = fidexioLoginPage.usernameInput.getAttribute("validationMessage");
        String expectedMessage = "Please fill in this field.";
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @When("User clicks reset password link")
    public void userClicksResetPasswordLink() {

        fidexioLoginPage.resetPasswordLink.click();

    }

    @Then("User should land reset password page and should see Reset Password text")
    public void userShouldLandResetPasswordPageAndShouldSeeResetPasswordText() {

        String expectedResetPasswordTitle = "Reset password | Best solution for startups";
        String actualResetPasswordTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedResetPasswordTitle, actualResetPasswordTitle);

    }

    @Then("User should see password as bullet signs")
    public void userShouldSeePasswordAsBulletSigns() {

        String expectedType = "password";
        String actualType = fidexioLoginPage.passwordInput.getAttribute("type");
        Assert.assertEquals(expectedType, actualType);
        
    }

    @And("User press Enter key")
    public void userPressEnterKey() {

        fidexioLoginPage.passwordInput.sendKeys(Keys.ENTER);

    }
}