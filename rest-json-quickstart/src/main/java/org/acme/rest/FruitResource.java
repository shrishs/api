package org.acme.rest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Fruit;

import io.micrometer.core.instrument.MeterRegistry;






@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
//@DenyAll
public class FruitResource {

    @Inject
    private MeterRegistry registry;

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    

    
    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    //@RolesAllowed("Admin")
    public Set<Fruit> list() {
        registry.counter("fruitListCounter").increment();
        return fruits;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }


}
