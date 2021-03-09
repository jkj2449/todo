package me.board.demo.server.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.board.demo.server.domain.post.Post;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getCreatedBy();
    }
}
