package seo.dale.notes.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import seo.dale.notes.model.Note;
import seo.dale.notes.repository.NoteRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {
    @Mock
    private NoteRepository repo;

    @InjectMocks
    private NoteService targetSrvc;

    @Test
    public void createsNoteWithDate() {
        Note newNote = new Note();
        assertThat(newNote.getDate()).isNull();

        targetSrvc.create(newNote);

        assertThat(newNote.getDate()).isNotNull();
        verify(repo).save(newNote);
    }

    @Test
    public void modifiesNoteWithId() {
        Note existingNote = new Note();
        existingNote.setTitle("Test Title");
        existingNote.setContent("This is a test content.");

        String id = UUID.randomUUID().toString();

        targetSrvc.modify(id, existingNote);

        assertThat(existingNote.getId()).isEqualTo(id);
        verify(repo).save(existingNote);
    }
}