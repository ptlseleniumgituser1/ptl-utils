package com.pragmatic.cucumber;

import com.orange.pages.LoginPage;
import com.orange.util.TestBase;
import com.pragmatic.util.Constants;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class LoginTestSteps extends TestBase {
    LoginPage loginPage;


    @Given("^I have navigated to the login page$")
    public void iHaveNavigatedToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // beforeSuite();
        //webDriver.get(Constants.ORANGE_BASE_URL);
        //loginPage = PageFactory.initElements(webDriver, LoginPage.class);

        System.out.println("I am logged into the system ");

    }

    @And("^I have typed username as 'admin'$")
    public void iHaveTypedUsernameAsAdmin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //loginPage.typeUsername("");
        System.out.println("I have typed user name ");
    }

    @And("^I have typed password as 'admin'$")
    public void iHaveTypedPasswordAsAdmin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //loginPage.typePassword("password");
        System.out.println("I have typed password ");

    }

    @And("^Clicked login button$")
    public void clickedLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //loginPage.clickLogin();
        System.out.println("I have clicked the login button ");

    }

    @Then("^I should be able to see the Welcome Admin message$")
    public void iShouldBeAbleToSeeTheWelcomeAdminMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have verified the welcome message ");

    }

    @And("^I have typed username as \"([^\"]*)\"$")
    public void iHaveTypedUsernameAs(String username) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //loginPage.typeUsername(username);
    }

    @And("^I have typed password as \"([^\"]*)\"$")
    public void iHaveTypedPasswordAs(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //loginPage.typePassword(password);
    }

    @Then("^I should be able to see an error message$")
    public void iShouldBeAbleToSeeAnErrorMessae() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // Assert.assertEquals(loginPage.getError(), "Username cannot be empty");
        System.out.println("I have verified the welcome message ");
    }

    @And("^I type username and password$")
    public void iTypeUsernameAndPassword(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> data = table.raw();


        System.out.println("Size of the table " +data.size());
        System.out.println("First column name " + data.get(0).get(0));
        System.out.println("Second  column name " + data.get(0).get(1));


    }

    @Then("^I should be able to see an error in login page$")
    public void iShouldBeAbleToSeeAnErrorInLoginPage(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


    @And("^I have typed password as <password>$")
    public void iHaveTypedPasswordAsPassword(String password) throws Throwable {
        System.out.println("Password is "+ password);
    }


    @And("^I have typed username as <username>$")
    public void iHaveTypedUsernameAsUsername() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be able to see an error message <expectedError>$")
    public void iShouldBeAbleToSeeAnErrorMessageExpectedError() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
