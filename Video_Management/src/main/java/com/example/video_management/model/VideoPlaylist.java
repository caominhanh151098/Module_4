package com.example.video_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public VideoPlaylist(Video video, Playlist playlist) {
        this.video = video;
        this.playlist = playlist;
    }
}
