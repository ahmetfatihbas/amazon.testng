package globalvariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String getProperty(String filename, String key) throws IOException {
        Properties prop = new Properties();
        String value = null;

        try {      // dosya hatalı da olsa çalışsın istiyorsak try catch metodunu kullanıyoruz.
            FileInputStream fis = new FileInputStream(filename);
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (IOException exception) {
            System.out.println("Hata oluştu : " + exception);
        }
        return value;
    }


    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("configuration.properties");
        prop.load(fis);

        String value = prop.getProperty(key);
        return value;
    }

    public static String getProperty(String filename, String key, String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(filename);
        prop.load(fis);

        prop.setProperty(key, value);
        FileOutputStream fos = new FileOutputStream("configuration.properties");
        prop.store(fos, null);
        return value;
    }
}


