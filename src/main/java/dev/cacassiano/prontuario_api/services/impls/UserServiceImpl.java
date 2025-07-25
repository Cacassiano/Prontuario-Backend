package dev.cacassiano.prontuario_api.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.cacassiano.prontuario_api.dtos.UserRequestDTO;
import dev.cacassiano.prontuario_api.entities.User;
import dev.cacassiano.prontuario_api.repositorys.UserRepository;
import dev.cacassiano.prontuario_api.services.interfaces.UserService;

@Repository
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

    @Override
    public User registerUser(UserRequestDTO request) {
        User docUser = new User();
        // Lembrar de por cripto
        docUser.setPassword(request.password());
        docUser.setTelephone(request.telephone());
        docUser.setUsername(request.username());
        docUser.setEmail(request.email());

        return userRepository.save(docUser);
    }
    
}
