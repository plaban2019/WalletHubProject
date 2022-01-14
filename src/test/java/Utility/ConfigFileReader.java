package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        try {

                String propertyFilePath = "src/main/resources/config.properties";
                reader = new BufferedReader(new FileReader(propertyFilePath));
                properties = new Properties();
                try {
                    properties.load(reader);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at ");
        }
    }
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }
    public String getFaceBookNumber() {
        String phone = properties.getProperty("phone");
        if(phone != null) return phone;
        else throw new RuntimeException("phone not specified in the Configuration.properties file.");
    }
    public String getFaceBookUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getFaceBookPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }
    public String getWalletHubProfileUrl() {
        String walletHubProfileUrl = properties.getProperty("walletProfilePage");
        if(walletHubProfileUrl != null) return walletHubProfileUrl;
        else throw new RuntimeException("walletHub Profile Url not specified in the Configuration.properties file.");
    }
    public String getWalletHubUrl() {
        String walletHubUrl = properties.getProperty("walletHubUrl");
        if(walletHubUrl != null) return walletHubUrl;
        else throw new RuntimeException("walletHub Url not specified in the Configuration.properties file.");
    }
    public String getWalletHubEmail() {
        String walletHubEmail = properties.getProperty("walletHubEmail");
        if(walletHubEmail != null) return walletHubEmail;
        else throw new RuntimeException("walletHub Email not specified in the Configuration.properties file.");
    }
    public String getWalletHubPassword() {
        String walletPassword = properties.getProperty("walletHubPass");
        if(walletPassword != null) return walletPassword;
        else throw new RuntimeException("walletHub Pass not specified in the Configuration.properties file.");
    }

}
