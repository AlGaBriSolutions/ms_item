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
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer cliente_id;
    private String pregunta;
    private String respuesta;

    @ManyToOne
    Item item;

    public Pregunta(Integer cliente_id, String pregunta, String respuesta) {
        this.cliente_id = cliente_id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Pregunta(Integer cliente_id, String pregunta, String respuesta, Item item) {
        this.cliente_id = cliente_id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.item = item;
    }

    

    
}
