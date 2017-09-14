import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "step_definitions",
        features = "classpath:features",
        plugin = {"pretty", "json:target/cucumber.json"}
)

public class RunCukesTest {

}
