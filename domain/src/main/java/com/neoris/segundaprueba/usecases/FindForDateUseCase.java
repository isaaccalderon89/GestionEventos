package com.neoris.segundaprueba.usecases;

import com.neoris.segundaprueba.entities.Evento;

import java.time.LocalDateTime;

public interface FindForDateUseCase {
    /**
     * Metodo que devuevle un evento que comprenda entre dos fechas. Los eventos pueden durar varios días.
     * @param dateTime le pasamos por parametro una fecha.
     * @return evento localizado por la fecha
     */
    Evento findForDate(LocalDateTime dateTime);
}
