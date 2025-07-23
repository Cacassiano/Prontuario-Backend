package dev.cacassiano.prontuario_api.dtos;

public record UserRequestDTO(
    String username,
    String password,
    String email
) {
}