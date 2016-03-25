package com.example.services;

import com.example.dao.FileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
@Service
public class FileProcessorImpl implements FileProcessor{

    @Override
    public Long countWordOccurrences(List<File> fileList) {
        return 99L;
    }
}
