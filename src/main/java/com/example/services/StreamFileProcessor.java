package com.example.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Sigora on 26.03.2016.
 */
@Service(FileProcessor.STREAM_FILE_PROCESSOR)
public class StreamFileProcessor implements FileProcessor {

    @Override
    public Long countWordOccurrences(List<File> fileList, String targetWord) {
        return fileList.parallelStream().mapToLong(f -> processFileStream(f, targetWord)).sum();
    }

    public long processFileStream(File file, String targetWord)  {
        long count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            count += br.lines().flatMap(s -> Stream.of(s.split(" "))).filter(w -> targetWord.equals(w)).count();
        }catch (IOException ex){
            ex.printStackTrace();
            return count;
        }
        return count;
    }
}
