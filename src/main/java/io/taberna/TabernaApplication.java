package io.taberna;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.taberna.conf.TabernaConf;

public class TabernaApplication extends Application<TabernaConf> {

    public static void main(String[] args) throws Exception {
        new TabernaApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TabernaConf> tabernaConfBootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TabernaConf tabernaConf, Environment environment) throws Exception {


        final ProductStore productStore = new ProductStore();
        environment.lifecycle().manage(productStore);

        environment.jersey().register(new ProductResource(productStore));
    }
}
