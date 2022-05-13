package com.adnan.additbackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="STORIES")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="link")
    private String url;

    private String post;

    @Column(nullable = false)
    private String title;

    public Story() {
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "story")
    private Set<Vote> votes = new HashSet<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createdAt = new Date();

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date modifiedAt = new Date();

    @Transient
    private Integer upvotes = 0;

    @Transient
    private Integer downvotes = 0;


    public Story addVote(Vote vote){
        vote.setStory(this);
        this.votes.add(vote);
        return this;
    }



}
