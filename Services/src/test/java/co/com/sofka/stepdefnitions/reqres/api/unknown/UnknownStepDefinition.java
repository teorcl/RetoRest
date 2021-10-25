package co.com.sofka.stepdefnitions.reqres.api.unknown;

import co.com.sofka.stepdefnitions.reqres.api.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.tasks.unknown.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class UnknownStepDefinition extends SetUp {

    @Given("que el usuario de la aplicacion se encuentre en home page")
    public void que_el_usuario_de_la_aplicacion_ha_definido_como_codigo() {
        setUp();

    }

    @When("el usuario de la aplicacion ejecuta la busqueda con el codigo {int}")
    public void el_usuario_de_la_aplicacion_ejecuta_la_busqueda(int codigoUser) {
        actor.attemptsTo(
                doGet().usingThe(String.format(RESOURCE, codigoUser))

        );
    }

    @Then("el usuario deberia obtener el resultado valido")
    public void el_usuario_deberia_obtener_el_resultado() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_OK,
                        response -> response
                                .statusCode(SC_OK)
                                .body("data.id", equalTo(2))
                                .body("data.name", equalTo("fuchsia rose"))
                                .body("data.year", equalTo(2001))
                                .body("data.color", equalTo("#C74375"))
                                .body("data.pantone_value", equalTo("17-2031"))

                )

        );
    }


    @Given("que el usuario de la aplicacion esta en pagina principal")
    public void que_el_usuario_de_la_aplicacion_esta_en_pagina_principal() {
        setUp();

    }

    @When("el usuario de la aplicacion busca con el codigo {int}")
    public void el_usuario_de_la_aplicacion_busca_con_el_codigo(int codigoUser) {
        actor.attemptsTo(
                doGet().

                        usingThe(String.format(RESOURCE, codigoUser))
        );
    }

    @Then("el usuario deberia obtener el resultado fallido")
    public void el_usuario_deberia_obtener_el_resultado_fallido() {
        actor.should(
                seeThatResponse(
                        "El código de respuesta HTTP debe ser: " + SC_NOT_FOUND,
                        response -> response
                                .statusCode(SC_NOT_FOUND)
                                .body("data", equalTo(null))
                )

        );
    }


}
