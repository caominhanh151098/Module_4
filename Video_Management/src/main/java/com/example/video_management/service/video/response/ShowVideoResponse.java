package com.example.video_management.service.video.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowVideoResponse {
    private String id;
    private String title;
    private String description;
    private String playlist;
}
