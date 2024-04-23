package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static final Properties props = new Properties();
    static {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//config.properties");
            props.load(file);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    /*
    private static Properties props = new Properties();
    CommonUtils utils = new CommonUtils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if(props.isEmpty()){
            try{
                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!!" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }*/
}
