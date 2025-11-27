package dwes.ejercicio04primeraweb.services;

import dwes.ejercicio04primeraweb.entities.Persona;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final Faker faker;
    public PersonaServiceImpl(Faker faker) {
        this.faker = faker;
    }

    @Override
    public Collection<Persona> find(int count) {
        Collection<Persona> personas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            personas.add(findOne());
        }
        return personas;
    }

    @Override
    public Persona findOne() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String dni = faker.idNumber().valid();
        LocalDate birthDate = faker.timeAndDate().birthday(18, 100);

        return new Persona(firstName, lastName, dni, birthDate);
    }
}
