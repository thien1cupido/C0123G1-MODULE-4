package com.example.validate_form_name_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {
    private Integer id;
    @Size(max = 800, message = "Name cannot be longer than 800 characters")
    @NotBlank(message = "Can't be left blank")
    private String nameSong;
    @Size(max = 300, message = "Name cannot be longer than 300 characters")
    @NotBlank(message = "Can't be left blank")
    private String nameSinger;
    @Size(max = 1000, message = "Name cannot be longer than 1000 characters")
    @NotBlank(message = "Can't be left blank")
    private String kindOfMusic;

    public SongDTO() {
    }

    public SongDTO(Integer id, String nameSong, String nameSinger, String kindOfMusic) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        String regexNameSong = "^[\\p{L}\\p{Mn}\\p{Pd}\\s]{0,800}$";
        String regexNameSinger = "^[\\p{L}\\p{Mn}\\p{Pd}\\s]{0,300}$";
        String regexKindOfSong = "^[\\p{L}\\p{Mn}\\p{Pd}\\s,]{0,1000}$";
        if (!songDTO.nameSong.matches(regexNameSong)) {
            errors.rejectValue("nameSong", "", "Does not contain special characters like @ ; , . = - + ,");
        }
        if (!songDTO.nameSong.matches(regexNameSinger)) {
            errors.rejectValue("nameSinger", "", "Does not contain special characters like @ ; , . = - + ,");
        }
        if (!songDTO.nameSong.matches(regexKindOfSong)) {
            errors.rejectValue("kindOfMusic", "", "Except for comma ',' and the remaining special characters are not allowed");
        }
    }
}
