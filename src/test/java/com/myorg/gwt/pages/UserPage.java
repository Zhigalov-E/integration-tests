package com.myorg.gwt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class UserPage extends PageObject {
    @FindBy(css = ".userGreetingMarker")
    private WebElementFacade userGreeting;
    @FindBy(css = ".logoutMarker")
    private WebElementFacade logoutLink;

    public WebElementFacade getUserGreeting() {
        return userGreeting;
    }

    public WebElementFacade getLogoutLink() {
        return logoutLink;
    }
}
