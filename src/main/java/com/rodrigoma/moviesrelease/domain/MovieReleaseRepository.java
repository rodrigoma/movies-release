package com.rodrigoma.moviesrelease.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieReleaseRepository extends MongoRepository<MovieRelease, Long> {

    @Query("{ visible: ?0 }")
    List<MovieRelease> findVisible(boolean visible);

    @Query("{ visible: ?0, stores: '?1' }")
    List<MovieRelease> findVisibleByStore(boolean visible, String store);

    @Query("{ visible: ?0, bd : { $exists : true } }")
    List<MovieRelease> findBDVisible(boolean visible);

    @Query("{ visible: ?0, dvd : { $exists : true } }")
    List<MovieRelease> findDVDVisible(boolean visible);
}