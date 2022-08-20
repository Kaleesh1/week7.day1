package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefs.ProjectSpecificMethods;

@CucumberOptions (features = {"src/test/java/feature"},
glue = {"stepDefs"},
monochrome= true,
publish= true)

public class RunCucumberTest extends ProjectSpecificMethods{

}
