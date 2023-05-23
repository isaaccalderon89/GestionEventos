package com.neoris.segundaprueba.usecases;

import com.neoris.segundaprueba.entities.Evento;

public interface UpdateEventoUseCase {
    /**
     * Método que sirve para actualizar un evento. Tenemos que pasarle el evento con el id y los datos que queremos modificar.
     * @param evento que queremos modificar
     * @return evento ya modificado
     */
    Evento updateEvento(Evento evento);

}
