package dev.cacassiano.prontuario_api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cacassiano.prontuario_api.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String>{

}
