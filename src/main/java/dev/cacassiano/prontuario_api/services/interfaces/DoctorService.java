package dev.cacassiano.prontuario_api.services.interfaces;

import dev.cacassiano.prontuario_api.dtos.DoctorRequestDTO;
import dev.cacassiano.prontuario_api.entities.Doctor;

public interface DoctorService {
    public Doctor registerDoctor(DoctorRequestDTO request);
}
