package com.example.alinoureddine.myapplication.backend;

import com.google.appengine.api.datastore.Blob;

/**
 * Created by alinoureddine on 5/25/16.
 */

public class Photo {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private Blob blobImage;

    public Blob getBlobImage() {
        return blobImage;
    }

    public void setBlobImage(Blob blobImage) {
        this.blobImage = blobImage;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", blobImage=" + blobImage +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }



//    public byte[] decodeBlobImage() { return com.google.api.client.util.Base64.decodeBase64(blobImage); }
}
