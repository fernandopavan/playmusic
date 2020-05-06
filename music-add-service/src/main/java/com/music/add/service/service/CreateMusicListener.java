package com.music.add.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.add.service.domain.Music;
import com.music.add.service.enums.MusicStatusEnums;
import com.music.add.service.gateway.json.MusicJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMusicListener {

    @Autowired
    private CreateMusicService createMusicService;

    @SendTo
    @KafkaListener(topics = "${kafka.topic.request-topic}")
    public String listen(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        MusicJson musicJson = mapper.readValue(json, MusicJson.class);

        Music build = Music.builder()
                .name(musicJson.getName())
                .status(MusicStatusEnums.WAIT_SAVE_PATH.toString())
                .uuidCustomer(musicJson.getUuidCustomer())
                .build();

        UUID uuid = createMusicService.execute(build);

        musicJson.setUuid(uuid.toString());

        return mapper.writeValueAsString(musicJson);
    }

}