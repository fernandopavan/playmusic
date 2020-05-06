package com.music.upload.service.gateway.json;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicJson {

    private String uuid;

    private String name;

    private String uuidCustomer;

    private String path;

    private long size;

}