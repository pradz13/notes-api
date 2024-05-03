package com.pradipta.notes.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "notes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @SequenceGenerator(name = "nt_id_seq_gen", sequenceName = "nt_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nt_id_seq_gen")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private Instant createdAt;
}
