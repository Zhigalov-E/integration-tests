package com.myorg.gwt.features.search;

import com.myorg.gwt.steps.serenity.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class LoginStory extends BaseSerenityStory {

    public static final String LOGIN = "ivan";
    public static final String PASSWORD = "secret";

    @Steps
    LoginSteps loginSteps;

    @Test
    public void login() {
        loginSteps.login(LOGIN, PASSWORD);
        loginSteps.checkUserName("Иван");
        loginSteps.clickOnLogOutLink();
        loginSteps.checkLoginForm();
    }
}
