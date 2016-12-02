package com.myorg.gwt.features.search;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.myorg.gwt.entities.UserRow;
import com.myorg.gwt.steps.serenity.LoginSteps;
import com.myorg.gwt.steps.serenity.UserListSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.spring.SpringIntegration;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
@ContextConfiguration("classpath:spring-data-context.xml")
@TestExecutionListeners({DbUnitTestExecutionListener.class})
public class UserPageStory extends BaseSerenityStory  {

    public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Rule
    public SpringIntegration springIntegration = new SpringIntegration();

    @Steps
    private UserListSteps userListSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test
    @DatabaseSetup("/data/setupUsersData.xml")
    @DatabaseTearDown("/data/tearDownUsersData.xml")
    public void checkUsersList() throws ParseException {
        loginSteps.login("john3", "secret");
        userListSteps.goToUsersList();
        List<UserRow> actualRows = new ArrayList<>();
        actualRows.add(new UserRow("John3", "Smith",formatter.parse("1985-02-05"),"john3.smith3@gmail.com"));
        actualRows.add(new UserRow("John", "Smith",formatter.parse("1986-02-05"),"john.smith@gmail.com"));
        actualRows.add(new UserRow("John5", "Smith",formatter.parse("1986-02-05"),"john5.smith5@gmail.com"));
        actualRows.add(new UserRow("John2", "Smith",formatter.parse("1987-02-05"),"john2.smith2@gmail.com"));
        actualRows.add(new UserRow("John4", "Smith",formatter.parse("1988-02-05"),"john4.smith4@gmail.com"));
        userListSteps.checkTableRows(actualRows);
    }
}
