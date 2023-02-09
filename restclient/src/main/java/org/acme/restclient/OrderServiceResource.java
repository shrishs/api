package org.acme.restclient;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;



@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderServiceResource {
    @Inject
    @RestClient
    FruitResourceRestClientInterface fruitResourceRestClientInterface;


    @GET
    public Set<Fruit> list() {
        return fruitResourceRestClientInterface.list();

    }
}
