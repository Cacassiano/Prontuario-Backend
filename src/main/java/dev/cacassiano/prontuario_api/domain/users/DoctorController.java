package dev.cacassiano.prontuario_api.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cacassiano.prontuario_api.dtos.DoctorRequestDTO;
import dev.cacassiano.prontuario_api.dtos.DoctorResponseDTO;
import dev.cacassiano.prontuario_api.services.interfaces.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<DoctorResponseDTO> registerDoctor(@RequestBody DoctorRequestDTO request){
        if (request.crm() == null || request.crm().isEmpty() ||
            request.username() == null || request.username().isEmpty() ||
            request.password() == null || request.password().isEmpty() ||
            request.specialtys() == null || request.specialtys().length == 0 ||
            request.email() == null || request.email().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(new DoctorResponseDTO(doctorService.registerDoctor(request)));
    }
}
