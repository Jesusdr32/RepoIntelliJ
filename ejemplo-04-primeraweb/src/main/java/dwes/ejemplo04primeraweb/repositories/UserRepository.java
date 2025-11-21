package dwes.ejemplo04primeraweb.repositories;

import dwes.ejemplo04primeraweb.entities.User;

public interface UserRepository {
    User findUserByEmail(String email);
}
