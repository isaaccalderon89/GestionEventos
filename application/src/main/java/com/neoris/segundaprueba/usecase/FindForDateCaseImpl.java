package com.neoris.segundaprueba.usecase;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.repository.EventoRepository;
import com.neoris.segundaprueba.usecases.FindForDateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class FindForDateCaseImpl implements FindForDateUseCase {

    @Autowired
    private EventoRepository eventoRepository;

    public FindForDateCaseImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento findForDate(LocalDateTime dateTime) {
        return eventoRepository.findForDate(dateTime);
    }
}
