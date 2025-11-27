package dwes.ejercicio04primeraweb.services;

import dwes.ejercicio04primeraweb.entities.Prediccion;

import java.util.Collection;

public interface PrediccionService {
    Collection<Prediccion> getPrediccionSemana();
}
