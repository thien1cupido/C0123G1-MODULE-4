package com.example.validate_form_name_song.service.impl;

import com.example.validate_form_name_song.model.Song;
import com.example.validate_form_name_song.repository.ISongRepository;
import com.example.validate_form_name_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAllSong() {
        return iSongRepository.findAll();
    }

    @Override
    public Boolean saveSong(Song song) {
        try {
            iSongRepository.save(song);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Song findBlogById(Integer id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public Boolean editSong(Song song) {
        try {
            iSongRepository.save(song);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
