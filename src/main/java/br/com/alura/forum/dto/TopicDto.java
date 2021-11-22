package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topic;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdDate;

    public TopicDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdDate = topic.getCreatedDate();
    }

    public static Page<TopicDto> converter(Page<Topic> topicos) {
        return topicos.map(TopicDto::new);
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
}
