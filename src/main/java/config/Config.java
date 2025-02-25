package main.java.config;

import io.restassured.config.LogConfig;

import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.RestAssured.config;
import static main.java.utils.Constants.*;

public class Config {

    private static Config instance;

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public static void ConfigLogOutput() {
        try {
            PrintStream printStream = new PrintStream("TestsResults.log");
            config = config().logConfig(LogConfig.logConfig().enablePrettyPrinting(true).defaultStream(printStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseUrl() {
        return BASE_URI;
    }
}
