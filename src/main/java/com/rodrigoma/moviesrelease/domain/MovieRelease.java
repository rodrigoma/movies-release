package com.rodrigoma.moviesrelease.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "releases")
public class MovieRelease {

    @Id
    private ObjectId id;

    private Movies movies;

    private List<PreOrder> preorders;

    private List<String> stores;

    private List<String> types;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public List<PreOrder> getPreorders() {
        return preorders;
    }

    public void setPreorders(List<PreOrder> preorders) {
        this.preorders = preorders;
    }

    public List<String> getStores() {
        return stores;
    }

    public void setStores(List<String> stores) {
        this.stores = stores;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}