package seo.dale.notes.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.notes.model.Note;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private Environment environment;

    @Test
    public void test() {
        Note note = new Note();
        noteRepository.save(note);

        List<Note> list = noteRepository.findAll();
        System.out.println("#list: " + list);
    }
}