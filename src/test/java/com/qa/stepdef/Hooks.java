package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.utils.DriverManager;
import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        BasePage basePage = new BasePage();
        basePage.closeApp();
        //basePage.removeApp();
        basePage.launchApp();
        new VideoManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        new VideoManager().stopRecording(scenario.getName());
        BasePage basePage = new BasePage();
        //basePage.removeApp();
        basePage.closeApp();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
/*        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }*/
    }
}
