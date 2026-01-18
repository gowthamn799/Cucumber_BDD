package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utilities.JsonReader;
import utilities.SeleniumActions;

public class LoginSteps {

    SeleniumActions actions = new SeleniumActions();
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User is on login page");
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        int totalUsers = JsonReader.getUserCount();
        for (int i = 0; i < totalUsers; i++) {
            String email = JsonReader.getEmailAt(i);
            String password = JsonReader.getPasswordAt(i);
            loginPage.loginUser(email, password);
            String actualEmail = loginPage.getLoggedInEmail();
            System.out.println("Expected Email: " + email + ", Actual Email: " + actualEmail);
            Assert.assertEquals(actualEmail, email, "Logged-in email mismatch for user: " + email);
            loginPage.logout();
        }

    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {

        System.out.println("User is redirected to dashboard");

    }
}
