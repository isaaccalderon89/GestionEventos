package com.neoris.segundaprueba.usecases;

import com.neoris.segundaprueba.entities.Evento;

import java.util.List;

public interface FindAllEventosUseCase {
    /**
     * Este métado devuelve una lista de todos los eventos. Normalmente utilizo este método para comprobar que la base de datos conecta correctamente.
     * @return una lista con todos los eventos
     */
    List<Evento> findAllEventos();

}
