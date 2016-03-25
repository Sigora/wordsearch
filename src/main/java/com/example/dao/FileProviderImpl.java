package com.example.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sigora on 25.03.2016.
 */
@Repository
public class FileProviderImpl implements FileProvider{

    @Override
    public List<File> getFileList() {
        File parent = new File("/");
        return parent != null ?  Arrays.asList(parent.listFiles()) : new ArrayList<File>();
    }
}
