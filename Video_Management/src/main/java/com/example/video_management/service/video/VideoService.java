package com.example.video_management.service.video;

import com.example.video_management.model.Playlist;
import com.example.video_management.model.Video;
import com.example.video_management.model.VideoPlaylist;
import com.example.video_management.repository.PlaylistRepository;
import com.example.video_management.repository.VideoPlaylistRepository;
import com.example.video_management.repository.VideoRepository;
import com.example.video_management.service.video.request.VideoSaveRequest;
import com.example.video_management.service.video.response.ShowVideoResponse;
import com.example.video_management.util.AppUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final VideoPlaylistRepository videoPlaylistRepository;
    private final PlaylistRepository playlistRepository;

    public List<ShowVideoResponse> getAll() {
        List<ShowVideoResponse> videos = videoRepository.findAll()
                .stream()
                .map(v -> AppUtils.mapper.map(v, ShowVideoResponse.class))
                .collect(Collectors.toList());
        for (var video : videos) {
                List<VideoPlaylist> videoPlaylists = videoPlaylistRepository.findAllByVideo_Id(Integer.parseInt(video.getId()));
                List<String> playlists = videoPlaylists.stream().map(vp -> vp.getPlaylist().getName()).collect(Collectors.toList());
                video.setPlaylist(String.join(", ", playlists));
        }
        return videos;
    }

    public void saveVideo(VideoSaveRequest videoRequest) {
        Video video = AppUtils.mapper.map(videoRequest, Video.class);
        videoRepository.save(video);
        videoRequest.getVideoPlaylists().forEach(vp -> {
            Playlist playlist = playlistRepository.findById(Integer.parseInt(vp));
            VideoPlaylist videoPlaylist = new VideoPlaylist(video, playlist);
            videoPlaylistRepository.save(videoPlaylist);
        });
    }

    public VideoSaveRequest getVideo(int id) {
        VideoSaveRequest saveRequest = AppUtils.mapper.map(videoRepository.findById(id), VideoSaveRequest.class);
        List<VideoPlaylist> videoPlaylists = videoPlaylistRepository.findAllByVideo_Id(id);
        for(var videoPlaylist : videoPlaylists) {
        saveRequest.getVideoPlaylists().add(String.valueOf(videoPlaylist.getPlaylist().getId()));
        }
        return saveRequest;
    }
    @Transactional
    public void editVideo(int id, VideoSaveRequest videoRequest) {
        Video video = AppUtils.mapper.map(videoRequest, Video.class);
        video.setId(id);
        videoRepository.save(video);
        videoPlaylistRepository.removeVideoPlaylistsByVideo_Id(id);
        videoRequest.getVideoPlaylists().forEach(vp -> {
            Playlist playlist = playlistRepository.findById(Integer.parseInt(vp));
            VideoPlaylist videoPlaylist = new VideoPlaylist(video, playlist);
            videoPlaylistRepository.save(videoPlaylist);
        });
    }

    @Transactional
    public void deleteVideo(int id) {
        Video video = videoRepository.findById(id);
        videoPlaylistRepository.removeVideoPlaylistsByVideo_Id(video.getId());
        videoRepository.removeVideoById(id);
    }
}
