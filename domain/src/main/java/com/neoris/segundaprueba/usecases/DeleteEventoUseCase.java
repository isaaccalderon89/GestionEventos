package com.neoris.segundaprueba.usecases;

import com.neoris.segundaprueba.entities.Evento;

public interface DeleteEventoUseCase {
    /**
     * Metódo que sirve para eliminar por el <b>id</b> un evento
     * @param id le pasado el id de un evento que exista y queramos eliminar
     * @return un <b>true</b> si el evento ha sido elimando, <b>false</b> en caso de que no se haya eliminado.
     */
    Boolean deleteEvento(Long id);
}
