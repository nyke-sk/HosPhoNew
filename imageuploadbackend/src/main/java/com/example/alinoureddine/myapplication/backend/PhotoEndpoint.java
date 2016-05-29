package com.example.alinoureddine.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "photoApi",
        version = "v1",
        resource = "photo",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.alinoureddine.example.com",
                ownerName = "backend.myapplication.alinoureddine.example.com",
                packagePath = ""
        )
)
public class PhotoEndpoint {

    private static final Logger logger = Logger.getLogger(PhotoEndpoint.class.getName());

    /**
     * This method gets the <code>Photo</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Photo</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getPhoto")
    public Photo getPhoto(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getPhoto method");
        return null;
    }

    /**
     * This inserts a new <code>Photo</code> object.
     *
     * @param photo The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertPhoto")
    public Photo insertPhoto(Photo photo) {
        // TODO: Implement this function
        logger.info("Calling insertPhoto method");
        return photo;
    }
}