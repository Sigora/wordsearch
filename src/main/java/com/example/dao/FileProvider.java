package com.example.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
public interface FileProvider {
    List<File> getFileList(String path) throws FileNotFoundException;
}
