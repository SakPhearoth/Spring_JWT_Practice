package co.practice.roth.springjwtpractice01.controller;

import co.practice.roth.springjwtpractice01.jwt.JwtUtils;
import co.practice.roth.springjwtpractice01.model.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authManager;

    @PostMapping
    public String login(@RequestBody LoginRequest request) {

        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword())
            );

            String token = jwtUtils.generateToken(request.getEmail());
            return token;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
