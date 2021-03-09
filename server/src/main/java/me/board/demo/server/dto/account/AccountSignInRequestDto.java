package me.board.demo.server.dto.account;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountSignInRequestDto {
    private String email;
    private String password;
}
