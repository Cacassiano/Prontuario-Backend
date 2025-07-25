package dev.cacassiano.prontuario_api.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.cacassiano.prontuario_api.dtos.DoctorRequestDTO;
import dev.cacassiano.prontuario_api.dtos.UserRequestDTO;
import dev.cacassiano.prontuario_api.entities.Doctor;
import dev.cacassiano.prontuario_api.entities.User;
import dev.cacassiano.prontuario_api.repositorys.DoctorRepository;
import dev.cacassiano.prontuario_api.services.interfaces.DoctorService;
import dev.cacassiano.prontuario_api.services.interfaces.UserService;


@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    public UserService userService;

    @Autowired
    public DoctorRepository doctorRepository;

    @Override
    public Doctor registerDoctor(DoctorRequestDTO request) {
        User user = userService.registerUser(new UserRequestDTO(request));
        
        Doctor newDoc = new Doctor();
        newDoc.setCrm(request.crm());
        newDoc.setSpecialtys(request.specialtys());
        newDoc.setUser_id(user.getId());
        newDoc.setUser(user);

        return doctorRepository.save(newDoc);
    }

    
}