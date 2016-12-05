package com.myorg.gwt.features.search;


import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class BaseSerenityStory {

    @Managed(uniqueSession = true)
    WebDriver webdriver;

}