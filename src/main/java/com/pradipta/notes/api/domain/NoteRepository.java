package com.pradipta.notes.api.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select new com.pradipta.notes.api.domain.NoteDTO(n.id, n.title, n.content, n.createdAt) from Note n")
    Page<NoteDTO> findBookmarks(Pageable pageable);
}
