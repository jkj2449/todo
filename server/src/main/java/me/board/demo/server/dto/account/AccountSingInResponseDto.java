package me.board.demo.server.dto.account;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.board.demo.server.domain.account.Account;

@NoArgsConstructor
@Getter
public class AccountSingInResponseDto {
    private Long id;
    private String email;
    private String username;

    @Builder
    public AccountSingInResponseDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.username = account.getUsername();
    }
}
