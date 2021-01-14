package com.example.neo4j.log4j2;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class FixShadedClassLoader extends ClassLoader {

    private final Pattern filterRegex = Pattern.compile(".*neo4j-logging.*Log4j2Plugins\\.dat$");

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        Enumeration<URL> resources = super.getResources(name);
        return new PredicateEnumeration<>(url -> !filterRegex.matcher(url.toString()).matches(), resources);
    }
}
