package seo.dale.notes.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception exception) {
        log.error("ERROR!", exception);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("url", req.getRequestURL());
        mav.addObject("exception", exception);
        return mav;
    }
}
