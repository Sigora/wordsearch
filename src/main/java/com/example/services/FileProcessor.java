package com.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
public interface FileProcessor {

    Long countWordOccurrences(List<File> fileList, String target) throws IOException;

    Long countWordOccurrencesStreamWay(List<File> fileList, String targetWord);
}
