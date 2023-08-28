package com.example.billmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "blog")
    private Set<BlogTag> blogTags;
    private String content;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private LocalDate publishDate;
}
