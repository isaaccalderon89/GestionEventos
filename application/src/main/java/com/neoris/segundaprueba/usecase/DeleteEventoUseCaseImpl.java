package com.neoris.segundaprueba.usecase;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.repository.EventoRepository;
import com.neoris.segundaprueba.usecases.DeleteEventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteEventoUseCaseImpl implements DeleteEventoUseCase {

    @Autowired
    private EventoRepository eventoRepository;


    @Override
    public Boolean deleteEvento(Long id) {
        return eventoRepository.deleteEvento(id);
    }
}
