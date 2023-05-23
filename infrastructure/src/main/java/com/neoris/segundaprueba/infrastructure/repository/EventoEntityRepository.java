package com.neoris.segundaprueba.infrastructure.repository;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.infrastructure.domain.entity.InMemoryEventoRepositoryEntity;
import com.neoris.segundaprueba.infrastructure.mapper.inmemory.InMemoryEventoEntityMapper;
import com.neoris.segundaprueba.infrastructure.repository.jpa.EventoJpaRepository;
import com.neoris.segundaprueba.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
/**
 * Constructor de la clase EventoEntityRepository.
 *
 * @param eventoJpaRepository El repositorio JPA EventoJpaRepository.
 */
@Repository
public class EventoEntityRepository implements EventoRepository {
    @Autowired
    private EventoJpaRepository eventoJpaRepository;

    public EventoEntityRepository(EventoJpaRepository eventoJpaRepository) {
        this.eventoJpaRepository = eventoJpaRepository;
    }

    @Override
    public Evento saveEvento(Evento evento) {
        InMemoryEventoRepositoryEntity savedEvento = eventoJpaRepository.save(InMemoryEventoEntityMapper.INSTANCE.fromDomainEntity(evento));
        return InMemoryEventoEntityMapper.INSTANCE.toDomainEntity(savedEvento);
    }

    @Override
    public Boolean deleteEvento(Long id) {
        if(eventoJpaRepository.existsById(id)){
            eventoJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Evento updateEvento(Evento evento) {
        InMemoryEventoRepositoryEntity savedEvento = eventoJpaRepository.save(InMemoryEventoEntityMapper.INSTANCE.fromDomainEntity(evento));
        return InMemoryEventoEntityMapper.INSTANCE.toDomainEntity(savedEvento);
    }


    @Override
    public List<Evento> findAllEventos() {
        List<InMemoryEventoRepositoryEntity> result = eventoJpaRepository.findAll();
        return InMemoryEventoEntityMapper.INSTANCE.toDomainEntityList(result);
    }

    @Override
    public Evento findForDate(LocalDateTime dateTime) {
        InMemoryEventoRepositoryEntity result = eventoJpaRepository.findForDate(dateTime);
        return InMemoryEventoEntityMapper.INSTANCE.toDomainEntity(result);
    }
}
