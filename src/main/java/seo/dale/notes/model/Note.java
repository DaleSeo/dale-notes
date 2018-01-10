package seo.dale.notes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    private ZonedDateTime date;
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }
}
