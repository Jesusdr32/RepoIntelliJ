package dwes.ejemplo04primeraweb.services;

import dwes.ejemplo04primeraweb.entities.User;
import dwes.ejemplo04primeraweb.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        System.out.println("findUserByEmail de UserService");
        return userRepository.findUserByEmail(email);
    }
}
