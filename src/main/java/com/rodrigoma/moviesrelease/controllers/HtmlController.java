package com.rodrigoma.moviesrelease.controllers;

import com.rodrigoma.moviesrelease.services.MovieReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.time.ZoneId.systemDefault;
import static java.util.Date.from;

@Controller
public class HtmlController {

    @Autowired
    private MovieReleaseService movieReleaseService;

    @GetMapping("/")
    public String calendar(Model model,
                           @RequestParam(name = "store", required = false) String store,
                           @RequestParam(name = "type", required = false) String type) {
        String events;

        if (store != null) {
            events = movieReleaseService.getByStore(store);
        } else if (type != null) {
            events = movieReleaseService.getByType(type);
        } else {
            events = movieReleaseService.getAllMovies();
        }

        model.addAttribute("initDate", formateDate(now()));
        model.addAttribute("events", events);

        return "index";
    }

    private String formateDate(LocalDate date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(from(date.atStartOfDay(systemDefault()).toInstant()));
    }
}