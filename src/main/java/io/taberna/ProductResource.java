package io.taberna;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.taberna.entity.Product;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    private final ProductStore productStore;

    public ProductResource(ProductStore productStore) {
        this.productStore = productStore;
    }


    @POST
    public Response addProduct(final Product product, @Context final UriInfo uriInfo)
            throws URISyntaxException {
        productStore.store(product);
        return Response.created(new URI("/" + product.getName())).build();
    }

    @GET
    @Timed
    @Path("{name}")
    public Product getProduct(@PathParam("name") final String name) {
        final Optional<Product> product = productStore.get(name);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new WebApplicationException(NOT_FOUND);
        }
    }

    @GET
    public HashMap<String, Product> getAllProducts() {
        return productStore.inmemStore;
    }
}
