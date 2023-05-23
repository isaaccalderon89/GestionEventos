package com.neoris.segundaprueba.usecases;

import com.neoris.segundaprueba.entities.Evento;

import java.time.LocalDateTime;

public interface SaveEventoUseCase {
    /**
     * Método que permite crear un evento
     * @param evento le pasamos un Json con todos los atributos de la clase
     * @return el evento creado.
     */
    Evento saveEvento(Evento evento);

}
