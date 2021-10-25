package co.com.sofka.stepdefnitions.reqres.api;

import io.restassured.response.ResponseBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.HashMap;

public class SetUp {
    protected static final String URL_BASE = "https://reqres.in";
    protected static final String RESOURCE = "/api/unknown/%s";
    protected String bodyRequest;
    protected Actor actor;


    private void setUpActor(){
        actor = Actor.named("Teo");
    }

    private void setUpActorAndApi(){
        actor.whoCan(CallAnApi.at(URL_BASE));
    }

    protected void setUp(){
        setUpActor();
        setUpActorAndApi();
    }

    protected HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type", "text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction", "");
        return headersCollection;
    }

    protected ResponseBody fromLastResponseBy(Actor actor){
        return LastResponse.received().answeredBy(actor).getBody();


    }
}
