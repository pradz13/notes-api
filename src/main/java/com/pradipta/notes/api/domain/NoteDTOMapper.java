package com.pradipta.notes.api.domain;

import org.springframework.stereotype.Component;

@Component
public class NoteDTOMapper {

    public NoteDTO toDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setContent(note.getContent());
        noteDTO.setCreatedAt(note.getCreatedAt());
        return noteDTO;
    }
}
