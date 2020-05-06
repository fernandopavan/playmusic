package com.music.add.service.service;

import com.music.add.service.domain.Music;
import com.music.add.service.gateway.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMusicService {

    @Autowired
    private MusicRepository musicRepository;

    public UUID execute(Music music) {
        music.setId(UUID.randomUUID());
        musicRepository.save(music);
        return music.getId();
    }

}