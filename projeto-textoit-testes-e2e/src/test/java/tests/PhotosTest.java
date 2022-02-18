package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@PhotosTeste",
glue = "cucumber.teste.passos", monochrome = true, dryRun = false, plugin = { "pretty", "html:target/cucumber-reports" }, publish = true)
public class PhotosTest {

}
