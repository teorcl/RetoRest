package co.com.sofka.runner.reqres.api.unknown;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/unknown/unknown.feature"},
        glue = {"co.com.sofka.stepdefnitions.reqres.api.unknown"},
        tags = "not @ignore"
)
public class UnknownRunner {
}
