package dwes.ejercicio04primeraweb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Persona {
    @EqualsAndHashCode.Include
    private final String firstName;
    private final String lastName;
    private final String dni;
    private final LocalDate birthDate;
    private final int actualAge;
}
