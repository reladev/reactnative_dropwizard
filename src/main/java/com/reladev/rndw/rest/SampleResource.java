package com.reladev.rndw.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.reladev.rndw.ManualModule;
import com.reladev.rndw.service.SampleService;

/**
 * Resource instantiated by guice. {@link SampleService} interface implementation is configured in guice module
 * {@link ManualModule}.
 *
 * {@link ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller} will force singleton
 * for resource, so manual singleton definition is not required.
 */
@Path("/sample")
@Produces("application/json")
public class SampleResource {

    private final SampleService service;

    @Inject
    public SampleResource(SampleService service) {
        this.service = service;
    }

    @GET
    @Path("/")
    public Response latest() {
        return Response.ok(service.foo()).build();
    }
}