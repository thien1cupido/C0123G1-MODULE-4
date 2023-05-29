package com.example.validate_form_name_song.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_song",columnDefinition = "TEXT")
    private String nameSong;
    @Column(name = "name_singer",columnDefinition = "TEXT")
    private String nameSinger;
    @Column(name = "kind_of_music",columnDefinition = "LONGTEXT")
    private String kindOfMusic;

    public Song() {
    }

    public Song(Integer id, String nameSong, String nameSinger, String kindOfMusic) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
