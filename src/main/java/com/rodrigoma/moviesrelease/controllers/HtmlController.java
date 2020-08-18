package com.rodrigoma.moviesrelease.controllers;

import com.rodrigoma.moviesrelease.services.MovieReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static com.rodrigoma.moviesrelease.domain.Stores.*;
import static com.rodrigoma.moviesrelease.domain.Types.BD;
import static com.rodrigoma.moviesrelease.domain.Types.DVD;
import static java.time.LocalDate.now;
import static java.time.ZoneId.systemDefault;
import static java.util.Date.from;

@Controller
public class HtmlController {

    @Autowired
    private MovieReleaseService movieReleaseService;

    @GetMapping("/")
    public String calendar(Model model) {
        model.addAttribute("initDate", formateDate(now()));

        model.addAttribute("allEvents", movieReleaseService.getAllMovies());

        model.addAttribute("bdEvents", movieReleaseService.getByType(BD.toString()));
        model.addAttribute("dvdEvents", movieReleaseService.getByType(DVD.toString()));

        model.addAttribute("amazonEvents", movieReleaseService.getByStore(AMAZON.toString()));
        model.addAttribute("versatilEvents", movieReleaseService.getByStore(VERSATIL.toString()));
        model.addAttribute("opEvents", movieReleaseService.getByStore(OBRASPRIMAS.toString()));

        model.addAttribute("toEvents", movieReleaseService.getByStore(THEORIGINALS.toString()));
        model.addAttribute("famEvents", movieReleaseService.getByStore(FAMDVD.toString()));
        model.addAttribute("clEvents", movieReleaseService.getByStore(CLASSICLINE.toString()));

        return "index";
    }

    private String formateDate(LocalDate date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(from(date.atStartOfDay(systemDefault()).toInstant()));
    }
}