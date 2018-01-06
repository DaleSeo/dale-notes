package seo.dale.notes.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import seo.dale.notes.model.Note;
import seo.dale.notes.model.NoteExcpetion;

@Repository
@Profile("development")
public class NoteRepositoryMem implements NoteRepository {
    private final Map<String, Note> map = new HashMap<>();

    @Override
    public List<Note> findAll() {
        return map.isEmpty() ? Collections.emptyList() : new ArrayList<>(map.values());
    }

    @Override
    public Note findOne(String id) {
        final Note note = map.get(id);
        if (note == null) {
            throw new NoteExcpetion("No data found");
        }
        return note;
    }

    @Override
    public void save(Note note) {
        if (note.getId() == null) {
            note.setId(UUID.randomUUID().toString());
        }
        map.put(note.getId(), note);
    }

    @Override
    public void delete(String id) {
        map.remove(id);
    }
}
