package com.neoris.segundaprueba.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evento {
    /**
     * Aqui tenemos la clase de negocio con anotaciones lombok para obtener el constructor con parametros,
     * constructor sin parametros, getters and setters.
     * @Author Isaac Calderón
     *
     */
    private Long id;
    private String description;
    private Integer capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;


}
