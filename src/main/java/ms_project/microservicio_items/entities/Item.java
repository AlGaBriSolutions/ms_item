package ms_project.microservicio_items.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    public Item(String titulo2, Integer clasificacion2, String foto2, String contenido2,
            List<Valoracion> valoraciones2, Integer tipoPrecio2, Integer precio2, List<Pregunta> preguntas2,
            Integer vendedor2, Integer disponibilidad2) {
                this.titulo = titulo2;
                this.clasificacion = clasificacion2;
                this.foto = foto2;
                this.contenido = contenido2;
                this.valoraciones = valoraciones2;
                this.tipoPrecio = tipoPrecio2;
                this.precio = precio2;
                this.preguntas = preguntas2;
                this.vendedor = vendedor2;
                this.disponibilidad = disponibilidad2;
    }
    public Item(String nombre, int i, String foto2, String contenido2, Integer tipoPrecio2, Integer precio2,
            Integer vendedor2, int i2) {
        this.titulo = nombre;
        this.clasificacion = i;
        this.foto = foto2;
        this.contenido = contenido2;
        this.tipoPrecio = tipoPrecio2;
        this.precio = precio2;
        this.vendedor = vendedor2;
        this.disponibilidad = i2;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String titulo;
    private Integer clasificacion;
    private String foto;
    private String contenido;
    @OneToMany(mappedBy = "item")
    private List<Valoracion> valoraciones;
    private Integer tipoPrecio;
    private Integer precio;
    @OneToMany(mappedBy = "item")
    private List<Pregunta> preguntas;
    private Integer vendedor;
    private Integer disponibilidad;
}
