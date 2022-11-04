package org.StepanKo.javarush.config;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties =new Properties();

    public static String getProperties(String name){
        if(properties.isEmpty()){
            try(BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get("src/dao.properties")))){
                properties.load(bis);
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return getProperties(name);
    }
}
