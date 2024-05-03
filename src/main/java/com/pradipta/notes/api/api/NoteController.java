package com.pradipta.notes.api.api;

import com.pradipta.notes.api.domain.Note;
import com.pradipta.notes.api.domain.NoteService;
import com.pradipta.notes.api.domain.NotesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public NotesDTO getNotes(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return noteService.getNotes(page);
    }
}
