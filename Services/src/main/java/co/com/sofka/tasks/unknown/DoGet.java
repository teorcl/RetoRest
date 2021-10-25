package co.com.sofka.tasks.unknown;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

public class DoGet implements Task {

    private String resource;
    private Map<String, Object> headers;
    private String bodyRequest;

    public DoGet usingThe(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(
                                req -> req.relaxedHTTPSValidation()
                        )
        );
    }

    public static DoGet doGet(){
        return new DoGet();
    }

}
