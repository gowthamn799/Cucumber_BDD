package pageObjects;

import utilities.JsonReader;
import utilities.SeleniumActions;

public class LoginPage extends SeleniumActions {
    private void signIn() {
     String xpath="//a[text()='Log in']";
     this.clickElement(xpath);
    }
    private void EmailField(String email){
        String xpath="//input[@name='Email']";
        this.enterText(xpath,email);
    }
    private void PasswordField(String password){
        String xpath="//input[@name='Password']";
        this.enterText(xpath,password);
    }
    private void RememberMeCheckbox(){
        String xpath="//input[@name='RememberMe']";
        this.clickElement(xpath);
    }
    private void loginButton(){
        String xpath="//input[@value='Log in']";
        this.clickElement(xpath);
    }
    private String loggedInEmailXpath = "//div[@class='header-links']//a[@class='account']";
    private String logoutBtnXpath     = "//a[text()='Log out']";

    public String getLoggedInEmail() {
        return this.getText(loggedInEmailXpath).trim();
    }

    public void logout() {
        this.clickElement(logoutBtnXpath);
        this.delay(2);
    }
    public void loginUser(String email, String password) {
        signIn();
        EmailField(email);
        PasswordField(password);
        loginButton();
        this.delay(2);
    }
}
