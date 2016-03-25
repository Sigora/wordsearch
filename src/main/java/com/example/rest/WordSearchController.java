package com.example.rest;
import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by Sigora on 25.03.2016.
 */
// The Java class will be hosted at the URI path "/wordsearch"
@Path("/")
@Component
public class WordSearchController {

    @GET
    @Produces("text/plain")
    @Path("/wordsearch")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
}
