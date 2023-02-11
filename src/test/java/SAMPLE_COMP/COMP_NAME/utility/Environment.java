package SAMPLE_COMP.COMP_NAME.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String END_USER_USERNAME;
    public static final String END_USER_PASSWORD;
    public static final String ENV_URL;
    public static final String ADMIN_USERNAME;
    public static final String ADMIN_PASSWORD;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_URL;
    public static final String API_BASEURL;

    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.getProperty("environment");

        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        END_USER_USERNAME= properties.getProperty("endUserUsername");
        END_USER_PASSWORD= properties.getProperty("endUserPassword");
        ADMIN_USERNAME= properties.getProperty("adminUsername");
        ADMIN_PASSWORD= properties.getProperty("adminPassword");
        ENV_URL= properties.getProperty("envURL");
        DB_USERNAME = properties.getProperty("dbUsername");
        DB_PASSWORD = properties.getProperty("dbPassword");
        DB_URL = properties.getProperty("dbUrl");
        API_BASEURL = properties.getProperty("apiURL");
    }

}
