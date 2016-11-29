package com.myorg.gwt.features.search;

import com.myorg.gwt.entities.UserRow;
import com.myorg.gwt.pages.UserListPage;
import com.myorg.gwt.steps.serenity.LoginSteps;
import com.myorg.gwt.steps.serenity.UserListSteps;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserPageStory extends BaseSerenityStory  {

    public static final String LOCALE_SEPARATOR = "=";
    public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private UserListPage userListPage;
    @Steps
    private UserListSteps userListSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test
    public void checkUsersList() throws ParseException {
        loginSteps.login(LoginStory.LOGIN, LoginStory.PASSWORD);
        userListPage.open();
        String locale = webdriver.findElement(By.xpath("//meta[@name='gwt:property']")).getAttribute("content");

        List<UserRow> actualRows = new ArrayList<>();
        actualRows.add(new UserRow("John", "Looters",formatter.parse("1976-02-05"),"looters.john@gmail.com"));
        actualRows.add(new UserRow("Иван","Петров",formatter.parse("1986-02-05"),"petrov.ivan@gmail.com"));
        userListSteps.checkTableRows(actualRows, locale.split(LOCALE_SEPARATOR)[1]);
    }
}
