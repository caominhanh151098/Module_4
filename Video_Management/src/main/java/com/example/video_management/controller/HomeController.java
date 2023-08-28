package com.example.video_management.controller;

import com.example.video_management.service.playlist.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {
    private final PlaylistService playlistService;
    @GetMapping
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        return model;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("playlist", playlistService.getAll());
        return model;
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView model = new ModelAndView("edit");
        model.addObject("playlist", playlistService.getAll());
        return model;
    }
}
