package com.example.rest;
import com.example.dao.FileProvider;
import com.example.services.FileProcessor;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FileProcessor fileProcessor;

    @Autowired
    private FileProvider fileProvider;

    @GET
    @Produces("text/plain")
    @Path("/wordsearch")
    public String getClichedMessage() {
        return fileProcessor.countWordOccurrences(fileProvider.getFileList()).toString();
    }
}
