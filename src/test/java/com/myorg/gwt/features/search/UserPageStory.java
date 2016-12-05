package com.myorg.gwt.features.search;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.myorg.gwt.entities.UserRow;
import com.myorg.gwt.steps.serenity.LoginSteps;
import com.myorg.gwt.steps.serenity.UserListSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import net.thucydides.core.annotations.Steps;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
@ContextConfiguration("classpath:spring-data-context.xml")
@TestExecutionListeners({DbUnitTestExecutionListener.class})
public class UserPageStory extends BaseSerenityStory  {

    @Rule
    public SpringIntegrationMethodRule methodRule = new SpringIntegrationMethodRule();

    @ClassRule
    public static SpringIntegrationClassRule classRule = new SpringIntegrationClassRule();

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
        actualRows.add(new UserRow("John3", "Smith","05-02-1985","john3.smith3@gmail.com"));
        actualRows.add(new UserRow("John", "Smith","05-02-1986","john.smith@gmail.com"));
        actualRows.add(new UserRow("John5", "Smith","05-02-1986","john5.smith5@gmail.com"));
        actualRows.add(new UserRow("John2", "Smith","05-02-1987","john2.smith2@gmail.com"));
        actualRows.add(new UserRow("John4", "Smith","05-02-1988","john4.smith4@gmail.com"));
        userListSteps.checkTableRows(actualRows);
    }
}
