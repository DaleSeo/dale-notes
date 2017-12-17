package seo.dale.notes.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class NoteExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception) {
        log.error("ERROR!", exception);
        return "error";
    }
}
