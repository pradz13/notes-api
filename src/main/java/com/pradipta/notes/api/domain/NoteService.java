package com.pradipta.notes.api.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    private final NoteDTOMapper noteDTOMapper;

    @Transactional(readOnly = true)
    public NotesDTO getNotes(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        return new NotesDTO(noteRepository.findAll(pageable).map(noteDTOMapper::toDTO));
    }
}
