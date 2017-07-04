//package myPackage;

import java.net.*;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(URL... urls) {
        super(urls, null);
    }

    @Override
    protected void finalize() {
        System.out.println("*** CustomClassLoader finalized!");
    }
}