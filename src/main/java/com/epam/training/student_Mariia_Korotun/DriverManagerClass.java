package com.epam.training.student_Mariia_Korotun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerClass {
    private static WebDriver webDriver;
    private DriverManagerClass() {}
    public static WebDriver getWebDriver(){
        if (webDriver == null) {
            initializeWebDriver();
        }
        return webDriver;
    }
    private static void initializeWebDriver(){
        String browser = System.getProperty("browser", "firefox");
        try {
            if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            } else if ("edge".equalsIgnoreCase(browser)) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            webDriver.manage().window().maximize();
            webDriver.get("https://www.saucedemo.com/");
        } finally {
            if (webDriver == null) {
                quitDriver();
            }
        }
    }
    private static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
