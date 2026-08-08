package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
}