package com.example.services;

import java.io.File;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
public interface FileProcessor {

    Long countWordOccurrences(List<File> fileList);
}
