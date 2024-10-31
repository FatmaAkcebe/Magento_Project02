package Runners;

import Utilites.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"",
        },
        glue = {"StepDefinitions"}

)
public class  ParalelTestRunner extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters("browserTipi")
    public void beforeClass(String browserTipi)
    {
//        GWD.threadBrowserName.set(browserTipi);

    }}