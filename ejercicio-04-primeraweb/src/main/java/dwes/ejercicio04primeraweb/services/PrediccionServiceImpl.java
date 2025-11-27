package dwes.ejercicio04primeraweb.services;

import dwes.ejercicio04primeraweb.entities.Prediccion;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class PrediccionServiceImpl implements PrediccionService {

    private final Faker faker;
    public PrediccionServiceImpl(Faker faker) {
        this.faker = faker;
    }

    @Override
    public Collection<Prediccion> getPrediccionSemana() {
        Collection<Prediccion> predicciones = new ArrayList<>();
        for (int i = 0; i < 7; i ++) {
            LocalDate fecha = LocalDate.now().plusDays(i);
            int probabilidadPrecipitacion = faker.number().numberBetween(0, 100);
            int tempMin = faker.number().numberBetween(0, 10);
            int tempMax = faker.number().numberBetween(10, 20);
            int alertaUV = faker.number().numberBetween(0, 5);
            predicciones.add(new Prediccion(fecha, probabilidadPrecipitacion, tempMin, tempMax, alertaUV));
        }
        return predicciones;
    }
}
