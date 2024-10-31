package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "",
        },
        glue = {"StepDefinitions"}, // Adım tanımları
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Raporlama seçenekleri
        monochrome = true // Konsolda daha okunabilir çıktı için
)
public class GeneralRunner extends AbstractTestNGCucumberTests {
}