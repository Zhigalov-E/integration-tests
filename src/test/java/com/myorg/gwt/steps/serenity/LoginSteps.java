package com.myorg.gwt.steps.serenity;

import com.myorg.gwt.pages.LoginPage;
import com.myorg.gwt.pages.UserPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;
    UserPage userPage;

    @Step
    public void goToLoginPage() {
        loginPage.open();
    }

    @Step
    public void enterLogin(String login) {
        loginPage.getLoginInput().type(login);
    }

    @Step
    public void enterPassword(String password) {
        loginPage.getPasswordInput().type(password);
    }

    @Step
    public void submitForm() {
        loginPage.getSubmitButton().click();
    }

    @Step
    public void checkLoginForm() {
        Assert.assertTrue(loginPage.getLoginForm().isPresent());
    }

    @Step
    public void checkUserName(String userName) {
        Assert.assertTrue(userPage.getUserGreeting().getText().contains(userName));
    }

    @Step
    public void clickOnLogOutLink() {
        userPage.getLogoutLink().click();
    }

    @Step
    public void login(String login, String password) {
        goToLoginPage();
        enterLogin(login);
        enterPassword(password);
        submitForm();
    }


}
