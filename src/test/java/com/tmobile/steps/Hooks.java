package com.tmobile.steps;

import com.tmobile.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    private static WebDriver driver; // W przypadku migracji na testy równoległe, należy zmienić podejście na wątkowo bezpieczne

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
