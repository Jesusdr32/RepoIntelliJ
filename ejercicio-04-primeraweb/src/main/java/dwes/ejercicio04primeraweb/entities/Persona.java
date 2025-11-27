package dwes.ejercicio04primeraweb.entities;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Persona {
    @EqualsAndHashCode.Include
    private final String firstName;
    private final String lastName;
    private final String dni;
    private final LocalDate birthDate;

    public int getEdad() {
        return  Period.between(birthDate, LocalDate.now()).getYears();
    }
}
