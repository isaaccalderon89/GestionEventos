package com.neoris.segundaprueba.usecase;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.repository.EventoRepository;
import com.neoris.segundaprueba.usecases.UpdateEventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateEventoCaseImpl implements UpdateEventoUseCase {

    @Autowired
    private EventoRepository eventoRepository;

    public UpdateEventoCaseImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento updateEvento(Evento evento) {
        return eventoRepository.updateEvento(evento);
    }
}
