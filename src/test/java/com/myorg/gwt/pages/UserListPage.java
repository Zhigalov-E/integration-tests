package com.myorg.gwt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://localhost:8080/gwt-mvp/#users:")
public class UserListPage extends PageObject {

    @FindBy(css = ".usersTableMarker")
    public WebElementFacade usersTable;

    public WebElementFacade getUsersTable() {
        return usersTable;
    }
}