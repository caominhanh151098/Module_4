package com.example.video_management.controller.rest;

import com.example.video_management.model.Video;
import com.example.video_management.service.video.VideoService;
import com.example.video_management.service.video.request.VideoSaveRequest;
import com.example.video_management.service.video.response.ShowVideoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@AllArgsConstructor
public class VideoRestController {
    private final VideoService videoService;

    @GetMapping
    public List<ShowVideoResponse> getVideos() {
        return videoService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> saveVideo(@Valid @RequestBody VideoSaveRequest videoRequest) {
        videoService.saveVideo(videoRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/edit/{id}")
    public VideoSaveRequest editVideo(@PathVariable int id) {
        return videoService.getVideo(id);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> saveEditVideo(@PathVariable int id, @RequestBody VideoSaveRequest videoRequest){
        videoService.editVideo(id, videoRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVideo(@PathVariable int id) {
        videoService.deleteVideo(id);
    }
}
