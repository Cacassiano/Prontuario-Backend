package dev.cacassiano.prontuario_api.dtos;

public record UserRequestDTO(
    String username,
    String password,
    String email,
    String telephone
) {
    public UserRequestDTO(DoctorRequestDTO doctorRequestDTO){
        this(
            doctorRequestDTO.username(),
            doctorRequestDTO.password(),
            doctorRequestDTO.email(),
            doctorRequestDTO.telephone()
        );
    }
}