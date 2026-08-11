package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/catalog")
public class CatalogResource {

    @Inject
    private CatalogService catalogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getCatalog() {
        return catalogService.getProducts();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        catalogService.addProduct(product);

        return Response.status(Response.Status.CREATED)
                .entity(product)
                .build();
    }
}