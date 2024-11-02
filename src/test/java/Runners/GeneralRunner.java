package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/FeatureFiles/US_07SearchFunctionality.feature",//US7
                "src/test/java/FeatureFiles/US_08WishList.feature",//US8
        },
        glue = {"StepDefinitions"}, // Adım tanımları
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Raporlama seçenekleri
        monochrome = true // Konsolda daha okunabilir çıktı için
)
public class GeneralRunner extends AbstractTestNGCucumberTests {
}