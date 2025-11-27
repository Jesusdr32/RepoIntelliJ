package dwes.ejercicio04primeraweb.entities;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Prediccion {
    @EqualsAndHashCode.Include
    private final LocalDate fecha;
    private final int probabilidadPrecipitacion;
    private final int tempMin;
    private final int tempMax;
    private final int alertaUV;

}
