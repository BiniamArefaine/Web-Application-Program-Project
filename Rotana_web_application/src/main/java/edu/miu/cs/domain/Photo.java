package edu.miu.cs.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PHOTOS")
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "LINK", nullable = false)
    private String link;

    public Photo(String link) {
        this.link = link;
    }

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", link='" + link + '\'' +
                '}';
    }
}
//