package dev.cacassiano.prontuario_api.services.interfaces;

import dev.cacassiano.prontuario_api.dtos.UserRequestDTO;
import dev.cacassiano.prontuario_api.entities.User;

public interface UserService {
    public User registerUser(UserRequestDTO request);
}
