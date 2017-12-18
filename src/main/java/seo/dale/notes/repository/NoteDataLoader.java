package seo.dale.notes.repository;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import seo.dale.notes.model.Note;

@Component
@Profile("development")
public class NoteDataLoader implements CommandLineRunner {
    private static final int NUM_OF_DATA = 10;

    private final NoteRepository noteRepo;

    public NoteDataLoader(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(0, NUM_OF_DATA)
                .mapToObj(no -> new Note("title #" + no, "This is the content for the title #" + no))
                .forEach(noteRepo::save);
    }
}
