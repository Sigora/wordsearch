package com.example.rest;
import com.example.dao.FileProvider;
import com.example.services.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

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

    @Value("${file.location}")
    private String fileLocation;

    @GET
    @Produces("text/plain")
    @Path("/wordsearch/{word}")
    public String countWords(@PathParam("word") String word) throws IOException {
        return fileProcessor.countWordOccurrences(fileProvider.getFileList(fileLocation), word).toString();
    }

    @GET
    @Produces("text/plain")
    @Path("/wordsearch/stream/{word}")
    public String countWordsStream(@PathParam("word") String word) throws IOException {
        return fileProcessor.countWordOccurrencesStreamWay(fileProvider.getFileList(fileLocation), word).toString();
    }

}
