package me.board.demo.server.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.board.demo.server.domain.post.Post;

@NoArgsConstructor
@Getter
public class PostSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}