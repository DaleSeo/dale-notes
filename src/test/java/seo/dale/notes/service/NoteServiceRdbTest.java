package seo.dale.notes.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.notes.model.Note;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceRdbTest {
    @Autowired
    private NoteService targetSrvc;

    @Test
    public void test() {
        Note newNote = new Note();

        Note savedNote = targetSrvc.create(newNote);

        System.out.println("#savedNoted: " + savedNote);
    }
}