package com.example.video_management.repository;

import com.example.video_management.model.Video;
import com.example.video_management.model.VideoPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoPlaylistRepository extends JpaRepository<VideoPlaylist, Integer> {
    List<VideoPlaylist> findAllByVideo_Id(int id);

    void removeVideoPlaylistsByVideo_Id(int id);

    void removeById(int id);
}
