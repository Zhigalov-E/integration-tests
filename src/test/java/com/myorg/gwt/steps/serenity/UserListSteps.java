package com.myorg.gwt.steps.serenity;

import com.myorg.gwt.entities.UserRow;
import com.myorg.gwt.pages.UserListPage;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserListSteps extends ScenarioSteps {

    private final String US_DATE_FORMAT = "dd-MM-yyyy";
    private final String RU_DATE_FORMAT = "yyyy-MM-dd";

    private UserListPage userListPage;

    @Step
    public void checkTableRows(List<UserRow> expectedRows, String locale) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat(locale.contains("en")
                ? US_DATE_FORMAT
                : RU_DATE_FORMAT);

        List<UserRow> actualRows = new ArrayList<>();
        List<WebElement> rows = userListPage.getUsersTable().findElements(By.xpath(".//tr[td]"));
        for(int i = 0; i < rows.size() - 1; i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            actualRows.add(new UserRow(
                    cells.get(0).getText(),
                    cells.get(1).getText(),
                    dateFormat.parse(cells.get(2).getText()),
                    cells.get(3).getText()
            ));
        }
        Assert.assertEquals(expectedRows, actualRows);
    }
}
