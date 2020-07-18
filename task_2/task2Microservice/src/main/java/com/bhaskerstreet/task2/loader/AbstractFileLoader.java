package com.bhaskerstreet.task2.loader;

import com.bhaskerstreet.task2.exception.NoImplementationException;

import java.io.IOException;

public abstract class AbstractFileLoader implements Loader {

    public String load() throws IOException {
        throw new NoImplementationException("No Implementation Exception");
    }
}
