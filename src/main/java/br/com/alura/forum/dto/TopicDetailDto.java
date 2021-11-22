package br.com.alura.forum.dto;

import br.com.alura.forum.model.TopicStatus;
import br.com.alura.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDetailDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdDate;
    private String autorName;
    private TopicStatus status;
    private List<AnswerDto> answerDtos;

    public TopicDetailDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdDate = topic.getCreatedDate();
        this.autorName = topic.getAutor().getName();
        this.status = topic.getStatus();
        this.answerDtos = new ArrayList<>();
        this.answerDtos.addAll(topic.getAnswer().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public TopicStatus getStatus() {
        return status;
    }

    public List<AnswerDto> getAnswerDtos() {
        return answerDtos;
    }
}
