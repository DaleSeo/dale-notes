package seo.dale.notes.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Note {
    private String id;
    private ZonedDateTime date;
    private String title;
    private String content;

    public Note() {
        this.id = UUID.randomUUID().toString();
        this.date = ZonedDateTime.now();
    }

    public Note(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.date = ZonedDateTime.now();
        this.title = title;
        this.content = content;
    }
}
