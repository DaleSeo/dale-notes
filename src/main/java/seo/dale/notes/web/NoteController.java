package seo.dale.notes.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seo.dale.notes.model.Condition;
import seo.dale.notes.model.Note;
import seo.dale.notes.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteSvc;

    public NoteController(NoteService noteSvc) {
        this.noteSvc = noteSvc;
    }

    @GetMapping("/list")
    public String getNoteList(Model model, Condition condition) {
        model.addAttribute(condition);
        model.addAttribute(noteSvc.list(condition));
        return "notes/list";
    }

    @GetMapping("/new")
    public String getNew(Model model) {
        model.addAttribute(new Note());
        return "notes/edit";
    }

    @PostMapping("/new")
    public String postNew(Note note) {
        noteSvc.create(note);
        return "redirect:/notes/list";
    }

    @GetMapping("/{id}/view")
    public String getNote(@PathVariable Long id, Model model) {
        model.addAttribute(noteSvc.detail(id));
        return "notes/view";
    }

    @GetMapping("/{id}/edit")
    public String getEdit(@PathVariable Long id, Model model) {
        model.addAttribute(noteSvc.detail(id));
        return "notes/edit";
    }

    @PostMapping("/{id}/edit")
    public String postEdit(@PathVariable Long id, Note note) {
        noteSvc.modify(id, note);
        return "redirect:/notes/{id}/view";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        noteSvc.delete(id);
        return "redirect:/notes/list";
    }
}
