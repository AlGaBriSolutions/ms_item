package ms_project.microservicio_items.entities;

import java.sql.Blob;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Blob foto;
    private String contenido;
    private ArrayList<Valoracion> valoraciones;
    private Integer tipo_precio;
    private Integer precio;
    private ArrayList<Pregunta> preguntas;
    private Integer vendedor;
    private Integer disponibilidad;
}
