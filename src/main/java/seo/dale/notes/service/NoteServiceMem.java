package seo.dale.notes.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import seo.dale.notes.model.Condition;
import seo.dale.notes.model.Note;
import seo.dale.notes.model.NoteExcpetion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("development")
public class NoteServiceMem implements NoteService {
    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Note> map = new HashMap<>();

    @Override
    public List<Note> list(Condition condition) {
        return map.isEmpty() ? Collections.emptyList() : new ArrayList<>(map.values());
    }

    @Override
    public Note detail(Long id) {
        final Note note = map.get(id);
        if (note == null) {
            throw new NoteExcpetion("No data found");
        }
        return note;
    }

    @Override
    public Note create(Note note) {
        note.setId(counter.getAndIncrement());
        map.put(note.getId(), note);
        return note;
    }

    @Override
    public Note modify(Long id, Note note) {
        map.put(id, note);
        return note;
    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }
}
