package dev.cacassiano.prontuario_api.dtos;

public record DoctorResponseDTO(
    String username,
    String email,
    String telephone,
    String crm,
    String[] specialty
) {
}