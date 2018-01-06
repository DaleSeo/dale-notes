package seo.dale.notes.service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import seo.dale.notes.model.Note;
import seo.dale.notes.repository.NoteRepository;

@Service
public class NoteService {
    private final NoteRepository noteRepo;

    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    public List<Note> list() {
        return noteRepo.findAll();
    }

    public Note detail(String id) {
        return noteRepo.findOne(id);
    }

    public void create(Note note) {
        note.setDate(ZonedDateTime.now(ZoneOffset.UTC));
        noteRepo.save(note);
    }

    public void modify(String id, Note note) {
        note.setId(id);
        note.setDate(ZonedDateTime.now(ZoneOffset.UTC));
        noteRepo.save(note);
    }

    public void remove(String id) {
        noteRepo.delete(id);
    }
}
