package com.rodrigoma.moviesrelease.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "releases-new")
public class MovieRelease {

    @Id
    private ObjectId id;

    private String title;

    private Bluray bd;

    private Dvd dvd;

    private boolean visible;

    private List<String> stores;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bluray getBd() {
        return bd;
    }

    public void setBd(Bluray bd) {
        this.bd = bd;
    }

    public boolean hasBd() {
        return this.bd != null;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public boolean hasDvd() {
        return this.dvd != null;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<String> getStores() {
        return stores;
    }

    public void setStores(List<String> stores) {
        this.stores = stores;
    }
}