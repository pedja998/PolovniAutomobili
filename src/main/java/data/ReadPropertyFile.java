package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\User\\Desktop\\Comtrade\\PolovniAutomobili\\src\\main\\java\\data\\Page.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
    }
}
