package com.pradipta.notes.api;

import com.pradipta.notes.api.domain.Note;
import com.pradipta.notes.api.domain.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final NoteRepository noteRepository;

    @Override
    public void run(String... args) throws Exception {
        noteRepository.save(new Note(null, "Test 1", "This is test note 1", Instant.now()));
        noteRepository.save(new Note(null, "Test 2", "This is test note 2", Instant.now()));
        noteRepository.save(new Note(null, "Test 3", "This is test note 3", Instant.now()));
    }
}
