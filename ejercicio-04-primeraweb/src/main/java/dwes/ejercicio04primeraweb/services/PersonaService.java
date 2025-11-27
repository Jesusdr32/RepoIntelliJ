package dwes.ejercicio04primeraweb.services;

import dwes.ejercicio04primeraweb.entities.Persona;
import java.util.Collection;

public interface PersonaService {
    Collection<Persona> find(int count);
    Persona findOne();
}
