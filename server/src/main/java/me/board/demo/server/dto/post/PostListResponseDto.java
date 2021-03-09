package me.board.demo.server.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import me.board.demo.server.domain.post.Post;

@NoArgsConstructor
@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    @Builder
    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getCreatedBy();
        this.modifiedDate = entity.getModifiedDate();
    }
}
