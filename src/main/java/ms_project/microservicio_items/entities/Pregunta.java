package ms_project.microservicio_items.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    private long id;
    private Integer cliente;
    private String pregunta;
    private String respuesta;
}
