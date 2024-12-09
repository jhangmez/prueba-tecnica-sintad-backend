package com.sintad_jhan.api.controller;

import com.sintad_jhan.api.dto.AuthResponse;
import com.sintad_jhan.api.dto.LoginRequest;
import com.sintad_jhan.api.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserDetailsService userDetailsService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();

            boolean passwordMatches = passwordEncoder.matches(password, userDetailsService.loadUserByUsername(username).getPassword());
            if (!passwordMatches) {
                throw new BadCredentialsException("Credenciales inválidas");
            }

            final String token = jwtUtil.generateToken(username);


            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {

            return ResponseEntity.status(401).body("Credenciales inválidas");
        } catch (Exception e) {

            return ResponseEntity.status(500).body("Error al iniciar sesión");
        }
    }
}
