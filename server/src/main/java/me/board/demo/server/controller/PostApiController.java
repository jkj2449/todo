package me.board.demo.server.controller;


import lombok.RequiredArgsConstructor;
import me.board.demo.server.domain.account.Role;
import me.board.demo.server.dto.post.*;
import me.board.demo.server.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @Secured(Role.RoleProperties.ROLE_USER)
    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {

        return postService.save(requestDto);
    }

    @Secured(Role.RoleProperties.ROLE_USER)
    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/api/v1/post")
    public Page<PostListResponseDto> findById(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @Secured(Role.RoleProperties.ROLE_USER)
    @DeleteMapping("/api/v1/post/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }
}
