package com.example.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
@Service
public class FileProcessorImpl implements FileProcessor{

    @Override
    public Long countWordOccurrences(List<File> fileList, String target) throws IOException {
        long wordCount = 0;

        for(File file : fileList){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line = br.readLine();
                while (line != null){
                    List<String> word = Arrays.asList(line.split(" "));
                    for(String wd : word){
                        if(wd.equals(target)){
                            wordCount++;
                        }
                    }
                    line = br.readLine();
                }
            }
        }

        return wordCount;
    }

    @Override
    public Long countWordOccurencesStreamWay(List<File> fileList, String targetWord) {
        return null;
    }

    public Long processFile(File file){
        return 0L;
    }
}
