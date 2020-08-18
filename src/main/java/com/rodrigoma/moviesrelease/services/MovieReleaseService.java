package com.rodrigoma.moviesrelease.services;

import com.google.gson.Gson;
import com.rodrigoma.moviesrelease.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.rodrigoma.moviesrelease.domain.Event.*;

@Service
public class MovieReleaseService {

    @Autowired
    private MovieReleaseRepository movieReleaseRepository;

    public String getAllMovies() {
        List<MovieRelease> movieReleases = movieReleaseRepository.findAll();
        return createEventArray(movieReleases);
    }

    public String getByType(String type) {
        List<MovieRelease> movieReleases = movieReleaseRepository.findByType(type);
        return createEventArray(movieReleases);
    }

    public String getByStore(String store) {
        List<MovieRelease> movieReleases = movieReleaseRepository.findByStore(store);
        return createEventArray(movieReleases);
    }

    private String createEventArray(List<MovieRelease> listMovies) {
        Gson gson = new Gson();

        List<Event> events = new ArrayList();

        listMovies.forEach(movieRelease -> {
            String colorStore = getColorByStore(movieRelease.getStores());
            String colorType = getColorByType(movieRelease.getTypes());

            events.add(release(
                    movieRelease.getMovies().getTitle(),
                    movieRelease.getMovies().getValue(),
                    movieRelease.getMovies().getUrl(),
                    movieRelease.getMovies().getDate(),
                    colorType));

            if (movieRelease.getPreorders() != null) {
                movieRelease.getPreorders().forEach(preOrder -> {
                    events.add(preorder(
                            movieRelease.getMovies().getTitle(),
                            preOrder.getValue(),
                            movieRelease.getMovies().getUrl(),
                            preOrder.getDate(),
                            colorType));
                });
            }
        });

        return gson.toJson(events);
    }

    private String getColorByStore(List<String> stores) {
        if (stores.size() > 1) {
            return Stores.TODOS.getColor();
        }

        return Stores.getColorBy(stores.get(0));
    }

    private String getColorByType(List<String> types) {
        if (types.size() > 1) {
            return Types.BOTH.getColor();
        }

        return Types.getColorBy(types.get(0));
    }
}