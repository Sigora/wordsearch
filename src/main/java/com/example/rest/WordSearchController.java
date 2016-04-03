package com.example.rest;
import com.example.dao.FileProvider;
import com.example.services.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Path("/")
@Component
public class WordSearchController {

    @Autowired
    @Qualifier(FileProcessor.DEFAULT_FILE_PROCESSOR)
    private FileProcessor defaultFileProcessor;

    @Autowired
    @Qualifier(FileProcessor.STREAM_FILE_PROCESSOR)
    private FileProcessor streamFileProcessor;

    @Autowired
    private FileProvider fileProvider;

    @Value("${file.location}")
    private String fileLocation;

    @GET
    @Produces("text/plain")
    @Path("/wordsearch/{word}")
    public String countWords(@PathParam("word") String word) throws IOException {
        long startTime = System.currentTimeMillis();
        long wordCount = defaultFileProcessor.countWordOccurrences(fileProvider.getFileList(fileLocation), word);
        long endTime = System.currentTimeMillis() - startTime;
        return "Word count = " + wordCount + " and request took " + endTime;
    }

    @GET
    @Produces("text/plain")
    @Path("/wordsearch/stream/{word}")
    public String countWordsStream(@PathParam("word") String word) throws IOException {
        long startTime = System.currentTimeMillis();
        long wordCount = streamFileProcessor.countWordOccurrences(fileProvider.getFileList(fileLocation), word);
        long endTime = System.currentTimeMillis() - startTime;
        return "Word count = " + wordCount + " and request took " + endTime;
    }



}
