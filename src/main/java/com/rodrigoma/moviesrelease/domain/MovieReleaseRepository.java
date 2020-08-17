package com.rodrigoma.moviesrelease.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieReleaseRepository extends MongoRepository<MovieRelease, Long> {

    @Query("{ stores: '?0' }")
    List<MovieRelease> findByStore(String store);

    @Query("{ types: '?0' }")
    List<MovieRelease> findByType(String type);

}