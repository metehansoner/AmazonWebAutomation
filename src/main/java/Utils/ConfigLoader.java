package Utils;

import Constants.EnvType;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.PRODUCTION));
        String filePath = new File("").getAbsolutePath();
        switch (EnvType.valueOf(env)) {
            case PRODUCTION -> properties = PropertyUtils.propertyLoader(filePath+"/src/main/resources/prod_config.properties");
            default -> throw new IllegalStateException("Invalid env type: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    public String getBrowser(){
        String prop = properties.getProperty("browser");
        if(prop != null) return prop;
        else throw new RuntimeException("property env is not specified in the stg_config.properties file");
    }
    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the stg_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the stg_config.properties file");
    }
}