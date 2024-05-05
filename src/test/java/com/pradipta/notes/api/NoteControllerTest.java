package com.pradipta.notes.api;

import com.pradipta.notes.api.domain.Note;
import com.pradipta.notes.api.domain.NoteRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
public class NoteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private NoteRepository noteRepository;

    private List<Note> notes;

    @BeforeEach
    void setUp() {
        noteRepository.deleteAllInBatch();
        notes = new ArrayList<>();
        notes.add(new Note(1L, "Title 1", "Title 1 Details", Instant.now()));
        notes.add(new Note(2L, "Title 2", "Title 2 Details", Instant.now()));
        notes.add(new Note(3L, "Title 3", "Title 3 Details", Instant.now()));
        notes.add(new Note(4L, "Title 4", "Title 4 Details", Instant.now()));
        notes.add(new Note(5L, "Title 5", "Title 5 Details", Instant.now()));
        noteRepository.saveAll(notes);
    }

    @Test
    void shouldGetNotes() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/notes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(5)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(1)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(false)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(false)));

    }
}
