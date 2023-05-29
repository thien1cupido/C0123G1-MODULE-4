package com.example.validate_form_name_song.controller;

import com.example.validate_form_name_song.dto.SongDTO;
import com.example.validate_form_name_song.model.Song;
import com.example.validate_form_name_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public ModelAndView showSongList() {
        return new ModelAndView("list", "songList", iSongService.findAllSong());
    }

    @GetMapping("/create")
    private String createNameSong(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @PostMapping("/createSong")
    public String saveSong(@Valid @ModelAttribute("songDTO") SongDTO songDTO, BindingResult bindingResult, Model model) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            Boolean check = iSongService.saveSong(song);
            model.addAttribute("check", check);
            return "create";
        }
    }


    @GetMapping("/edit/{id}")
    public String sendSong(Model model, @PathVariable("id") Integer id) {
        Song song = iSongService.findBlogById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        model.addAttribute("songDTO", songDTO);
        return "update";
    }

    @PostMapping("/updateSong")
    public String editSong(@Valid @ModelAttribute("songDTO") SongDTO songDTO, BindingResult bindingResult) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "update";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            iSongService.editSong(song);
            return "redirect:/edit/" + song.getId();
        }
    }
}
