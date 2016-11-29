package com.myorg.gwt.features.search;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseSerenityStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

}