package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
public class Hooks {
        public static WebDriver driver;

        @Before
        public static void setup(){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to("https://demo.nopcommerce.com/ ");
        }

        @After
        public static void teardown(){
            driver.quit();
        }
    }

