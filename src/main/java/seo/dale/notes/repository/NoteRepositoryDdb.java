package seo.dale.notes.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import seo.dale.notes.model.Note;

import java.util.List;

@Repository
public class NoteRepositoryDdb implements NoteRepository {
    private final DynamoDBMapper dbMapper;

    @Autowired
    public NoteRepositoryDdb(DynamoDBMapper dbMapper) {
        this.dbMapper = dbMapper;
    }

    @Override
    public List<Note> findAll() {
        return dbMapper.scan(Note.class, new DynamoDBScanExpression());
    }

    @Override
    public Note findOne(String id) {
        return dbMapper.load(Note.class, id);
    }

    @Override
    public void save(Note note) {
        dbMapper.save(note);
    }

    @Override
    public void delete(String id) {
        final Note note = new Note();
        note.setId(id);
        dbMapper.delete(note);
    }
}
