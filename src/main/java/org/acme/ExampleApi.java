package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="example-api")
@ApplicationScoped
@Path("/api/v1")
public interface ExampleApi {

    @POST
    @Path("/foobar")
    @Consumes({"application/json"})
    public void foobar(String requestBody);
}
