package dev.cacassiano.prontuario_api.dtos;

import dev.cacassiano.prontuario_api.entities.Doctor;

public record DoctorResponseDTO(
    String id,
    String username,
    String email,
    String telephone,
    String crm,
    String[] specialtys
) {
    public DoctorResponseDTO(Doctor doc) {
        this(
            doc.getUser_id().toString(),
            doc.getUser().getUsername(),
            doc.getUser().getEmail(),
            doc.getUser().getTelephone(),
            doc.getCrm(),
            doc.getSpecialtys()
        );
    }
}