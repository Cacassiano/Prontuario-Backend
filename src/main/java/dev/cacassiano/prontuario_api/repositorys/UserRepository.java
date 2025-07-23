package dev.cacassiano.prontuario_api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cacassiano.prontuario_api.entitys.User;
public interface UserRepository extends  JpaRepository<User, String> {
}
