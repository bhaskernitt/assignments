package com.bhaskerstreet.task2.loader.fileLoader;

import com.bhaskerstreet.task2.loader.AbstractFileLoader;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class FileLoader extends AbstractFileLoader {

    private String path;

    public FileLoader(String path) {
        this.path = path;
    }

    @Override
    public String load() throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream(path));
    }
}
