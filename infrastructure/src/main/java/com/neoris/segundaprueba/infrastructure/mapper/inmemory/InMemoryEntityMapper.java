package com.neoris.segundaprueba.infrastructure.mapper.inmemory;

import java.util.List;

/**
 * Interfaz para el mapeo entre entidades de dominio y entidades en memoria.
 * @param <DOMAIN_ENTITY> El tipo de la entidad de dominio.
 * @param <INMEMORY_ENTITY> El tipo de la entidad de memoria.
 */
public interface InMemoryEntityMapper <DOMAIN_ENTITY, INMEMORY_ENTITY>{
    /**
     * Convierte una entidad en memoria en una entidad de dominio
     * @param inmemoryEntity la entidad en memoria que se va a convertir
     * @return la entidad de dominio correspondiente.
     */
    DOMAIN_ENTITY toDomainEntity(INMEMORY_ENTITY inmemoryEntity);

    /**
     * Convierte una entidad de dominio en una entidad de memoria.
     * @param domainEntity La entidad de dominio que se va a convertir.
     * @return La entidad en memoria correspondiente.
     */
    INMEMORY_ENTITY fromDomainEntity(DOMAIN_ENTITY domainEntity);
    /**
     * Convierte una lista de entidades en memoria en una lista de entidades de dominio.
     *
     * @param inmemoryEntities La lista de entidades en memoria que se va a convertir.
     * @return La lista de entidades de dominio correspondiente.
     */
    List<DOMAIN_ENTITY> toDomainEntityList(List<INMEMORY_ENTITY> inmemoryEntities);

}
