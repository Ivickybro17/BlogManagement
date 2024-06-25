package com.example.blogmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int likes;

    public void incrementlikes(){
        this.likes++;
    }
    public void decrementlikes(){
        this.likes--;
    }

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "posts")
    private List<Comments> comments;

    private String content;

    private String status;

    private LocalDateTime created_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }
}
