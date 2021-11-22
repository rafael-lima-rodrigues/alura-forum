package br.com.alura.forum.dto;

import br.com.alura.forum.model.Answer;

import java.time.LocalDateTime;

public class AnswerDto {

    private Long id;
    private String message;
    private LocalDateTime createdDate;
    private String autorName;

    public AnswerDto(Answer answer){
        this.id = answer.getId();
        this.message = answer.getMessage();;
        this.createdDate = answer.getCreatedDate();
        this.autorName = answer.getAutor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getAutorName() {
        return autorName;
    }
}
