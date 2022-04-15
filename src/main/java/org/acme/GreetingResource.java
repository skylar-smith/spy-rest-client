package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @Inject
    @RestClient
    ExampleApi exampleApi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        exampleApi.foobar("foo");
        return "Hello RESTEasy";
    }
}