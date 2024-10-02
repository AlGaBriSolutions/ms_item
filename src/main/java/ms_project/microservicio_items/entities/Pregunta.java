package ms_project.microservicio_items.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    public Pregunta(int i, String string, String string2, Item item) {
        this.cliente = i;
        this.pregunta = string;
        this.respuesta = string2;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer cliente;
    private String pregunta;
    private String respuesta;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
