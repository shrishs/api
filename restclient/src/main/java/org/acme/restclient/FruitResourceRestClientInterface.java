package org.acme.restclient;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "fruitrestclient")
@Path("/fruits")
public interface FruitResourceRestClientInterface {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Fruit> list() ;

}
