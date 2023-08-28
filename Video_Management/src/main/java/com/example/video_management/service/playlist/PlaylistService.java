package com.example.video_management.service.playlist;

import com.example.video_management.model.Playlist;
import com.example.video_management.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }
}
