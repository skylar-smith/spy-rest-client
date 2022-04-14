package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@QuarkusTest
public class GreetingResourceTest {

    @InjectSpy
    @RestClient
    ExampleApi exampleApi;

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
        Mockito.verify(exampleApi,Mockito.atLeastOnce()).foobar(any(), any());
    }

}