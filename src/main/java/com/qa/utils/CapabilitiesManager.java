package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    CommonUtils utils = new CommonUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
      //  Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());

            switch(params.getPlatformName()){
                case "Android":
                    caps.setCapability("automationName", PropertyManager.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", PropertyManager.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", PropertyManager.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    //caps.setCapability("autoGrantPermissions", true);

                    break;
//                case "iOS":
//                    caps.setCapability("automationName", PropertyManager.getProperty("iOSAutomationName"));
//                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "SwagLabsMobileApp.app";
//                    utils.log().info("appUrl is" + iOSAppUrl);
//                    caps.setCapability("bundleId", PropertyManager.getProperty("iOSBundleId"));
//                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
//                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
//                    caps.setCapability("app", iOSAppUrl);
//                    break;
            }
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
