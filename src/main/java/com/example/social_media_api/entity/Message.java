package com.example.social_media_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(nullable = false, length = 255)
    private String message_text;

    @Column(name = "posted_by", nullable = false)
    private Integer postedBy;

    private Long time_posted_epoch;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }


    public Integer getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
    }

    public Long getTime_posted_epoch() {
        return time_posted_epoch;
    }

    public void setTime_posted_epoch(Long time_posted_epoch) {
        this.time_posted_epoch = time_posted_epoch;
    }
}
