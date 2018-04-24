package com.sap.dummy.broker.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sap.dummy.broker.configuration.Configuration;
import com.sap.dummy.broker.domain.Catalog;

@Path("/catalog")
public class CatalogResource {

    private Configuration configuration = new Configuration();

    @GET
    public Catalog getCatalog() {
        return configuration.getCatalog();
    }

}