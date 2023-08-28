package com.example.video_management.repository;

import com.example.video_management.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findAll();

    Video findById(int id);

    void removeVideoById(int id);
}
