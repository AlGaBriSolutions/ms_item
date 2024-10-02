package ms_project.microservicio_items.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer calificacion;
    private Integer cliente_id;
    private String comentario;

    @ManyToOne
    Item item;

    public Valoracion(Integer calificacion, Integer cliente_id, String comentario, Item item) {
        this.calificacion = calificacion;
        this.cliente_id = cliente_id;
        this.comentario = comentario;
        this.item = item;
    }

    
}
