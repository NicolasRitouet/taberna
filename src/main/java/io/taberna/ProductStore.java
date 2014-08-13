package io.taberna;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import io.dropwizard.lifecycle.Managed;
import io.taberna.entity.Product;

import java.util.HashMap;

public class ProductStore implements Managed {

    final HashMap<String, Product> inmemStore = Maps.newHashMap();
    private boolean running = true;

    public void store(final Product product) {
        inmemStore.put(product.getName(), product);
    }

    public Optional<Product> get(final String name) {
        return Optional.fromNullable(inmemStore.get(name));
    }

    @Override
    public void start() throws Exception {
        running = true;
    }

    @Override
    public void stop() throws Exception {
        running = false;
    }
}
