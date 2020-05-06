package com.music.upload.api.gateway.http;

import com.music.upload.api.gateway.json.MusicUploadJson;
import com.music.upload.api.service.UploadMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class MusicController {

    @Autowired
    private UploadMusicService uploadMusicService;

    @PostMapping("/customers/{uuidCustomer}/musics/{uuidMusic}")
    public ResponseEntity<?> create(@PathVariable("uuidCustomer") String uuidCustomer,
                                    @PathVariable("uuidMusic") String uuidMusic,
                                    @RequestParam("file") MultipartFile file) throws IOException {
        MusicUploadJson build = MusicUploadJson.builder()
                .uuid(uuidCustomer)
                .uuidMusic(uuidMusic)
                .file(file)
                .build();

        uploadMusicService.execute(build);

        return ResponseEntity.ok().build();
    }

}