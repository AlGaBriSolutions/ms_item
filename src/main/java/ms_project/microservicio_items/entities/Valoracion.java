package ms_project.microservicio_items.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Valoracion {
    private long id;
    private Integer calificacion;
    private Integer cliente;
    private String comentario;
}
