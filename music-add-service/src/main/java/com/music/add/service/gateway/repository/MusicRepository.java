package com.music.add.service.gateway.repository;

import com.music.add.service.domain.Music;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicRepository extends CrudRepository<Music, UUID> {

}