package com.neoris.segundaprueba.usecase;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.repository.EventoRepository;
import com.neoris.segundaprueba.usecases.FindAllEventosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllEventosCaseImpl implements FindAllEventosUseCase {
    @Autowired
    private EventoRepository eventoRepository;

    public FindAllEventosCaseImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> findAllEventos() {
        return eventoRepository.findAllEventos();
    }
}
