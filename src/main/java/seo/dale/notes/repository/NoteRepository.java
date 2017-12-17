package seo.dale.notes.repository;

import java.util.List;

import seo.dale.notes.model.Note;

public interface NoteRepository {

    List<Note> findAll();

    Note findOne(String id);

    void save(Note note);

    void delete(String id);
}
