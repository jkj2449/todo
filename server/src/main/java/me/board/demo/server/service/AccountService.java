package me.board.demo.server.service;


import lombok.RequiredArgsConstructor;
import me.board.demo.server.common.security.JwtTokenProvider;
import me.board.demo.server.domain.account.*;
import me.board.demo.server.dto.account.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public AccountSingInResponseDto signIn(AccountSignInRequestDto requestDto) {
        Account account = accountRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("일치하는 email이 없습니다."));

        if (!passwordEncoder.matches(requestDto.getPassword(), account.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        JwtTokenProvider.setTokenInHeader(account);

        return AccountSingInResponseDto.builder()
                .account(account)
                .build();
    }

    @Override
    public Account loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 email이 없습니다."));;

        return account;
    }

    @Transactional
    public void signUp(AccountSignUpRequestDto requestDto) {
        Account account = Account.builder()
                .email(requestDto.getEmail())
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .role(Role.USER.getRole())
                .build();

        account.encodePassword(passwordEncoder);
        accountRepository.save(account);
    }
}
