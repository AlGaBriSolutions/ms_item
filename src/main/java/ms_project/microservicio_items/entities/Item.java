package ms_project.microservicio_items.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String titulo;
    private Integer clasificacion;
    private String foto;
    private String contenido;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Valoracion> valoraciones = new ArrayList();

    //0: Dólares
    //1: Pesos colombianos
    //2: Bolívares
    private Integer tipo_precio;
    private Integer precio;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Pregunta> preguntas = new ArrayList();

    //Varia desde 0 hasta 14
    private Integer vendedor;
    private Boolean disponibilidad;

    public Item(String titulo, Integer clasificacion, String foto, String contenido, Integer tipo_precio, Integer precio, Integer vendedor, Boolean disponibilidad) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.foto = foto;
        this.contenido = contenido;
        this.tipo_precio = tipo_precio;
        this.precio = precio;
        this.vendedor = vendedor;
        this.disponibilidad = disponibilidad;
    }

}
