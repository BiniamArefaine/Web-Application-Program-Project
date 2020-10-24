package edu.miu.cs.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private User followed;
    @OneToOne(cascade = CascadeType.MERGE)
    private User follower;
    private LocalDateTime followTime = LocalDateTime.now();

    public Follow() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public LocalDateTime getFollowTime() {
        return followTime;
    }

    public void setFollowTime(LocalDateTime followTime) {
        this.followTime = followTime;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", followed=" + followed +
                ", follower=" + follower +
                ", followTime=" + followTime +
                '}';
    }
}
//