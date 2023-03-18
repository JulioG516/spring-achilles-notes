package com.achilles.achillesnote.controller;

import com.achilles.achillesnote.data.NoteRepository;
import com.achilles.achillesnote.model.Note;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    static List<Note> noteList = new ArrayList<>();
    static{
        noteList.add(new Note("Novo", "Adicionar novo meio"));
    }

    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/")
    public String getWelcomePage() {
        return "index";
    }

    @GetMapping("/notes")
    public String showNotesPage(ModelMap modelMap) {
        modelMap.addAttribute("noteList", noteRepository.findAll());
        return "notes";
    }

    @PostMapping("/notes")
    public String addNewNote(@RequestParam String title, @RequestParam String text) {
        Note note = new Note(title, text);
        noteRepository.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{noteId}")
    public String deleteById(@PathVariable("noteId") int noteId) {
        noteRepository.deleteById(noteId);
        return "redirect:/notes";
    }
}
