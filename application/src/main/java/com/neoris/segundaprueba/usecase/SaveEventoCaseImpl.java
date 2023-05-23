package com.neoris.segundaprueba.usecase;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.repository.EventoRepository;
import com.neoris.segundaprueba.usecases.SaveEventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class SaveEventoCaseImpl implements SaveEventoUseCase {
    @Autowired
    private EventoRepository eventoRepository;

    public SaveEventoCaseImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento saveEvento(Evento evento) {
        return eventoRepository.saveEvento(evento);
    }
}
