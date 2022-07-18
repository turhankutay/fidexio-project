package com.fidexio.step_definitions;

import com.fidexio.pages.FidexioLogOutPage;
import com.fidexio.pages.FidexioLoginPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Fidexio_Logout_StepDefinitions {

    FidexioLoginPage fidexioLoginPage = new FidexioLoginPage();
    FidexioLogOutPage fidexioLogOutPage = new FidexioLogOutPage();

    @Given("User is on the homepage after login with valid credentials.")
    public void userIsOnTheHomepageAfterLoginWithValidCredentials() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        fidexioLoginPage.usernameInput.sendKeys("posmanager15@info.com");
        fidexioLoginPage.passwordInput.sendKeys("posmanager" + Keys.ENTER);

    }

    @When("the user clicks on the username in the upper right corner")
    public void theUserClicksOnTheUsernameInTheUpperRightCorner() {

        fidexioLogOutPage.usernameInTheUpperRightCorner.click();

    }

    @And("click on log out")
    public void clickOnLogOut() {

        fidexioLogOutPage.logoutLink.click();

    }

    @Then("User should log out and land on login page and should see title is Login | Best solution for startups")
    public void userShouldLogOutAndLandOnLoginPage() {

        String expectedTitle = "Login | Best solution for startups";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @And("User clicks step back button")
    public void userClicksStepBackButton() {

      Driver.getDriver().navigate().back();
        
    }

    @Then("The user cannot return to the homepage and should see Your Odoo session expired. Please refresh the current web page. message")
    public void theUserCannotReturnToTheHomepageAndShouldSeeYourOdooSessionExpiredPleaseRefreshTheCurrentWebPageMessage() {

        String expectedMessage = "Odoo Session Expired";
        String actualMessage = fidexioLogOutPage.expiredAlert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
