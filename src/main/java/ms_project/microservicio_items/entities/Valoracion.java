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
public class Valoracion {
    public Valoracion(int i, int j, String string, Item item2) {
        this.calificacion = i;
        this.cliente = j;
        this.comentario = string;
        this.item = item2;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer calificacion;
    private Integer cliente;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "valoracion_id")
    private Item item;
}
