package seo.dale.notes.model;

public class NoteExcpetion extends RuntimeException {
    public NoteExcpetion() {
    }

    public NoteExcpetion(String message) {
        super(message);
    }

    public NoteExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteExcpetion(Throwable cause) {
        super(cause);
    }

    public NoteExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
