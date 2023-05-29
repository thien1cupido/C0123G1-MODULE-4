package com.example.validate_form_name_song.service;

import com.example.validate_form_name_song.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAllSong();

    Boolean saveSong(Song song);

    Song findBlogById(Integer id);

    Boolean editSong(Song song);
}
