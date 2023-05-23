package com.neoris.segundaprueba.infrastructure.mapper.inmemory;

import com.neoris.segundaprueba.entities.Evento;
import com.neoris.segundaprueba.infrastructure.domain.entity.InMemoryEventoRepositoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Interfaz de mapeo en memoria para la entidad de Evento.
 * Extiende {@Link InMemoryEntityMapper} para porporcionar métodos de mapeo especificos para la entidad del evento
 */
@Mapper
public interface InMemoryEventoEntityMapper extends InMemoryEntityMapper<Evento, InMemoryEventoRepositoryEntity>{
    /**
     * Instancia del mapeador de entidades InMemoryEventoEntityMapper.
     */
    InMemoryEventoEntityMapper INSTANCE = Mappers.getMapper(InMemoryEventoEntityMapper.class);
    /**
     * Convierte una entidad en memoria de tipo InMemoryEventoRepositoryEntity en una entidad de dominio de tipo Evento.
     *
     * @param inmemoryEntity La entidad en memoria que se va a convertir.
     * @return La entidad de dominio de tipo Evento correspondiente.
     */
    @Override
    @Mapping(source="id", target= "id")
    Evento toDomainEntity(InMemoryEventoRepositoryEntity inmemoryEntity);
}
