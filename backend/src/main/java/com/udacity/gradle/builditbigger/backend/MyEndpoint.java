package com.udacity.gradle.builditbigger.backend;

import com.example.android.javalib.JokesJava;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "cleanJoke")
    public MyBean cleanJoke(@Named("name") String name) {
        MyBean response = new MyBean();
        JokesJava jokesJava = new JokesJava();
        name = jokesJava.randomCleanJoke();
        response.setData(name);

        return response;
    }

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "dirtyJoke")
    public MyBean dirtyJoke(@Named("name") String name) {
        MyBean response = new MyBean();
        JokesJava jokesJava = new JokesJava();
        name = jokesJava.randomDirtyJoke();
        response.setData(name);

        return response;
    }

}
