package seo.dale.notes.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.notes.AwsConfiguration;
import seo.dale.notes.model.Note;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AwsConfiguration.class)
public class NoteRepositoryDdbTest {
    private NoteRepositoryDdb noteRepo;

    @Autowired
    private DynamoDBMapper dbMapper;


    @Before
    public void setUp() throws Exception {
        noteRepo = new NoteRepositoryDdb(dbMapper);
    }

    @Test
    public void test() {
        final Note note = new Note("Test Title", "This is the content.");
        noteRepo.save(note);

        System.out.println("#findOne:" + note.getId());
        System.out.println("#findAll:" + noteRepo.findAll());

        noteRepo.delete(note.getId());
    }
}
