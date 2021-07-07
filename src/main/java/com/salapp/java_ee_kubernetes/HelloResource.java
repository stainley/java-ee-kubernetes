package com.salapp.java_ee_kubernetes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/say")
public class HelloResource {

    @Inject
    @ConfigProperty(name = "message")
    private String message;

    @GET
    public Response message() {
        return Response.ok(message).build();
    }

}
