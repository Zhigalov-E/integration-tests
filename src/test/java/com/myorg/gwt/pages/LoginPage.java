package com.myorg.gwt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://localhost:8080/gwt-mvp/login.jsp")
public class LoginPage extends PageObject {
    @FindBy(name = "username")
    private WebElementFacade loginInput;
    @FindBy(name = "password")
    private WebElementFacade passwordInput;
    @FindBy(name = "submit")
    private WebElementFacade submitButton;
    @FindBy(name = "f")
    private WebElementFacade loginForm;

    public WebElementFacade getLoginInput() {
        return loginInput;
    }

    public WebElementFacade getPasswordInput() {
        return passwordInput;
    }

    public WebElementFacade getSubmitButton() {
        return submitButton;
    }

    public WebElementFacade getLoginForm() {
        return loginForm;
    }
}
