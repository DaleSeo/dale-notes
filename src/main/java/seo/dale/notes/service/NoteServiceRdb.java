package seo.dale.notes.service;

import org.springframework.stereotype.Service;
import seo.dale.notes.model.Condition;
import seo.dale.notes.model.Note;
import seo.dale.notes.repository.NoteRepository;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class NoteServiceRdb implements NoteService {
    private final NoteRepository noteRepo;

    public NoteServiceRdb(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public List<Note> list(Condition condition) {
        return noteRepo.findAll();
    }

    @Override
    public Note detail(Long id) {
        return noteRepo.findOne(id);
    }

    @Override
    public Note create(Note note) {
        note.setDate(ZonedDateTime.now(ZoneOffset.UTC));
        return noteRepo.save(note);
    }

    @Override
    public Note modify(Long id, Note note) {
        note.setId(id);
        return noteRepo.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepo.delete(id);
    }
}
