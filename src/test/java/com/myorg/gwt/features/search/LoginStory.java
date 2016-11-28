package com.myorg.gwt.features.search;

import com.myorg.gwt.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void login() {
        loginSteps.login("ivan", "secret");
        loginSteps.checkUserName("Иван");
        loginSteps.clickOnLogOutLink();
        loginSteps.checkLoginForm();
    }
}
