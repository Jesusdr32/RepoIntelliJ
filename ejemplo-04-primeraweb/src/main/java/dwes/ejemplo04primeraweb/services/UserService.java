package dwes.ejemplo04primeraweb.services;

import dwes.ejemplo04primeraweb.entities.User;

public interface UserService {
    User findUserByEmail(String email);
}
