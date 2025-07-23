package dev.cacassiano.prontuario_api.infra.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cacassiano.prontuario_api.dtos.UserRequestDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(201).body("User registered successfully");
    }
}
