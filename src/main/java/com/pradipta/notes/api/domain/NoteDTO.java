package com.pradipta.notes.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private Long id;

    private String title;

    private String content;

    private Instant createdAt;
}
