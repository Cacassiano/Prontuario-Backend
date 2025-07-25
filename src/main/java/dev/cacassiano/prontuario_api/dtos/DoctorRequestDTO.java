package dev.cacassiano.prontuario_api.dtos;

public record DoctorRequestDTO(
    String username,
    String password,
    String email,
    String crm,
    String telephone,
    String[] specialtys
) {
    
}