package com.example.dao;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
@Repository
public class ClassPathFileProvider implements FileProvider{

    @Override
    public List<File> getFileList(String fileLocation) throws FileNotFoundException {
        String fullPath = getClass().getClassLoader().getResource(fileLocation).getPath();
        File parent = new File(fullPath);
        return parent != null ?  Arrays.asList(parent.listFiles()) : new ArrayList<File>();
    }
}
