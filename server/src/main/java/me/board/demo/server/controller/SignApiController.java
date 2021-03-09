package me.board.demo.server.controller;


import lombok.RequiredArgsConstructor;
import me.board.demo.server.dto.account.*;
import me.board.demo.server.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignApiController {
    private final AccountService accountService;

    // 로그인
    @PostMapping("/api/v1/signIn")
    public AccountSingInResponseDto signIn(@RequestBody AccountSignInRequestDto requestDto) {
        return accountService.signIn(requestDto);
    }

    @PostMapping("/api/v1/signUp")
    public ResponseEntity<Void> signUp(@RequestBody AccountSignUpRequestDto requestDto) {
        accountService.signUp(requestDto);
        return ResponseEntity.ok().build();
    }

}
