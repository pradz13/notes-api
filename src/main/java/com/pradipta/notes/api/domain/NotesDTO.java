package com.pradipta.notes.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class NotesDTO {
    private List<Note> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    @JsonProperty("isFirst")
    private boolean isFirstPage;

    @JsonProperty("isLast")
    private boolean isLastPage;
    private boolean hasPrevious;
    private boolean hasNext;

    public NotesDTO(Page<Note> notePage) {
        this.data = notePage.getContent();
        this.totalElements = notePage.getTotalElements();
        this.totalPages = notePage.getTotalPages();
        this.currentPage = notePage.getNumber() + 1;
        this.isFirstPage = notePage.isFirst();
        this.isLastPage = notePage.isLast();
        this.hasNext = notePage.hasNext();
        this.hasPrevious = notePage.hasPrevious();
    }
}
