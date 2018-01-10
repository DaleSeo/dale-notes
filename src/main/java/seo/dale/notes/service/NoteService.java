package seo.dale.notes.service;

import seo.dale.notes.model.Condition;
import seo.dale.notes.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> list(Condition condition);

    Note detail(Long id);

    Note create(Note note);

    Note modify(Long id, Note note);

    void delete(Long id);
}
