package com.adnan.additbackend.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="VOTES")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(value = EnumType.STRING)
    private Direction direction;

    @ManyToOne
    private Story story;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createdAt = new Date();

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date modifiedAt;

    public Vote() {
    }

    public Vote(Direction direction) {
        this.direction = direction;
    }

    public Long getId() {
        return this.id;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Story getStory() {
        return this.story;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }


}
