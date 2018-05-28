package queryapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUp {

    public String getDataProperties(String param){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Projects\\queryApp\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(param);
    }
}
