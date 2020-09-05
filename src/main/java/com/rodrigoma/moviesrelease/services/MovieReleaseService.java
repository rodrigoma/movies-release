package com.rodrigoma.moviesrelease.services;

import com.google.gson.Gson;
import com.rodrigoma.moviesrelease.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.rodrigoma.moviesrelease.domain.Event.preorder;
import static com.rodrigoma.moviesrelease.domain.Event.release;
import static com.rodrigoma.moviesrelease.domain.Types.*;

@Service
public class MovieReleaseService {

    @Autowired
    private MovieReleaseRepository movieReleaseRepository;

    public String getAllMovies() {
        List<MovieRelease> movieReleases = movieReleaseRepository.findVisible(true);
        return createEventArray(movieReleases, ALL);
    }

    public String getAllBlurays() {
        List<MovieRelease> movieReleases = movieReleaseRepository.findBDVisible(true);
        return createEventArray(movieReleases, BD);
    }

    public String getAllDvds() {
        List<MovieRelease> movieReleases = movieReleaseRepository.findDVDVisible(true);
        return createEventArray(movieReleases, DVD);
    }

    public String getByStore(String store) {
        List<MovieRelease> movieReleases = movieReleaseRepository.findVisibleByStore(true, store);
        return createEventArray(movieReleases, ALL);
    }

    public Long countBlurays() {
        return movieReleaseRepository.countBD();
    }

    public Long countDvds() {
        return movieReleaseRepository.countDVD();
    }

    private String createEventArray(List<MovieRelease> listMovies, Types midiaType) {
        Gson gson = new Gson();

        List<Event> events = new ArrayList();

        listMovies.forEach(movie -> {
            String title = movie.getTitle();

            if (movie.hasBd() && (BD.equals(midiaType) || ALL.equals(midiaType))) {
                createEvent(events, title, movie.getBd());
            }

            if (movie.hasDvd() && (DVD.equals(midiaType) || ALL.equals(midiaType))) {
                createEvent(events, title, movie.getDvd());
            }
        });

        return gson.toJson(events);
    }

    private void createEvent(List<Event> events, String title, Midia midiaType) {
        events.add(release(
                title,
                midiaType.getValue(),
                midiaType.getUrl(),
                midiaType.getDate(),
                midiaType.getColor()));

        if (midiaType.getPreorders() != null) {
            midiaType.getPreorders().stream()
                    .filter(preOrder -> todayAndBeyond(preOrder.getDate()))
                    .forEach(
                            preOrder -> events.add(preorder(
                                    title,
                                    preOrder.getValue(),
                                    midiaType.getUrl(),
                                    preOrder.getDate(),
                                    midiaType.getColor())));
        }
    }

    private boolean todayAndBeyond(String preorderDate) {
        LocalDate preorder = LocalDate.parse(preorderDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate now = LocalDate.now();


        return preorder.isEqual(now) || preorder.isAfter(now);
    }
}