package com.example.validate_form_name_song.repository;

import com.example.validate_form_name_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
