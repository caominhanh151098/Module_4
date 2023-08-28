package com.example.video_management.service.video.request;

import com.example.video_management.model.VideoPlaylist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoSaveRequest {
    private String id;
    private String title;
    private String description;
    private List<String> videoPlaylists = new ArrayList<>();
    private String url;
}
