package com.example;

import com.example.rest.WordSearchController;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Sigora on 25.03.2016.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(WordSearchController.class);
        packages("com.example.rest");
        register(LoggingFilter.class);
    }
}